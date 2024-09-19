import { useState } from "react";
import "./App.css";
import Viewer from "./components/Viewer";
import Controller from "./components/Controller";

function App() {
  const [count, setCount] = useState(0);
  const handlerCountUp = (step) => {
    setCount(count + step);
  };

  return (
    <>
      <section>
        <Viewer count={count} />
      </section>
      <section>
        <Controller onClickButton={handlerCountUp} />
      </section>
    </>
  );
}

export default App;
