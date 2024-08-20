var canvas = document.getElementById('myCanvas'),
	ctx = canvas.getContext('2d'),
	canvasWidth = canvas.width,
	canvasHeight = canvas.height,
	bounds = { maxLon: 1, minLon: 200, maxLat: 1, minLat: 200 };

// 각 좌표들을 순회하며 최소 및 최대 경도와 위도를 계산합니다.
data.features.forEach(function (feature) {
	feature.geometry.coordinates.forEach(function (coordsSet) {
		coordsSet.forEach(function (coords) {
			coords.length <= 1
				? updateBounds(coords)
				: coords.forEach(function (coord) {
						updateBounds(coord);
				  });
		});
	});
});

var drawnPolygons = [];

// 각 지리 데이터를 순회하며 캔버스에 폴리곤을 그립니다.
data.features.forEach(function (feature) {
	var polygonData = {
		name: feature.properties.adm_nm,
		properties: feature.properties,
		paths: [],
	};
	feature.geometry.coordinates.forEach(function (coordsSet) {
		var currentPath = [];

		coordsSet.forEach(function (coords) {
			if (coords.length <= 2) {
				var x = lonToX(coords[0]),
					y = latToY(coords[1]);
				currentPath.push({ x: x, y: y });
			} else {
				currentPath = [];
				coords.forEach(function (coord) {
					var x = lonToX(coord[0]),
						y = latToY(coord[1]);
					currentPath.push({ x: x, y: y });
				});
				polygonData.paths.push(currentPath);
			}
		});
		polygonData.paths.push(currentPath);
	});

	drawnPolygons.push(polygonData);
});

// 그려진 폴리곤들을 캔버스에 그립니다.
drawnPolygons.forEach(function (polygon) {
	polygon.paths.forEach(function (path) {
		ctx.save();
		ctx.beginPath();
		var isFirstPoint = true;
		path.forEach(function (point) {
			if (isFirstPoint) {
				ctx.moveTo(point.x, point.y);
				isFirstPoint = false;
			} else {
				ctx.lineTo(point.x, point.y);
			}
		});
		ctx.strokeStyle = 'black';
		ctx.stroke();
		ctx.closePath();
		ctx.restore();
	});
});

var sortedPolygons = [];

// 경도와 위도를 이용해 캔버스의 X 좌표를 계산합니다.
function lonToX(lon) {
	var normalizedLon = (lon - bounds.minLon) / (bounds.maxLon - bounds.minLon);
	return canvasWidth * normalizedLon;
}

// 경도와 위도를 이용해 캔버스의 Y 좌표를 계산합니다.
function latToY(lat) {
	var normalizedLat = (lat - bounds.minLat) / (bounds.maxLat - bounds.minLat);
	return canvasHeight - canvasHeight * normalizedLat;
}

// 경도와 위도를 바탕으로 최소, 최대 값을 업데이트합니다.
function updateBounds(coords) {
	var lon = coords[0],
		lat = coords[1];
	bounds.minLon = Math.min(lon, bounds.minLon);
	bounds.maxLon = Math.max(lon, bounds.maxLon);
	bounds.minLat = Math.min(lat, bounds.minLat);
	bounds.maxLat = Math.max(lat, bounds.maxLat);
}

// 포인트가 특정 폴리곤 내부에 있는지 확인합니다.
// Ray casting algorithm 사용함
function getPolygonNameAtPoint(point) {
	var foundPolygonName = false;
	sortedPolygons.forEach(function (polygon) {
		var crossings = 0;
		for (var i = 0; i < polygon.path.length; i++) {
			var currPoint = polygon.path[i],
				nextPoint = polygon.path[(i + 1) % polygon.path.length];
			if (currPoint.y > point.y != nextPoint.y > point.y) {
				var intersectX =
					((nextPoint.x - currPoint.x) * (point.y - currPoint.y)) /
						(nextPoint.y - currPoint.y) +
					currPoint.x;
				if (point.x < intersectX) crossings++;
			}
		}
		if (crossings % 2 > 0) foundPolygonName = polygon.name;
	});
	return foundPolygonName;
}

// 폴리곤을 y 좌표에 따라 내림차순으로 정렬합니다.
drawnPolygons.forEach(function (polygon) {
	var sortedPolygon = { name: polygon.name, path: [] };
	polygon.paths.forEach(function (path) {
		path.forEach(function (point) {
			sortedPolygon.path.push({ x: point.x, y: point.y });
		});
	});
	sortedPolygon.path.sort(function (a, b) {
		return b.y - a.y;
	});
	sortedPolygons.push(sortedPolygon);
});

// 마우스 움직임에 따라 폴리곤 이름을 출력합니다.
canvas.addEventListener('mousemove', function (event) {
	var polygonName = getPolygonNameAtPoint({
		x: event.clientX - canvas.offsetLeft,
		y: event.clientY - canvas.offsetTop,
	});
	if (polygonName) console.log(polygonName);
});
canvas.addEventListener('click', function (event) {
	var polygonName = getPolygonNameAtPoint({
		x: event.clientX - canvas.offsetLeft,
		y: event.clientY - canvas.offsetTop,
	});
	if (polygonName) alert(polygonName);
});
