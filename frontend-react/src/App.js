// import './App.css';
import WelcomeComponent from './components/WelcomeComponent';
import CarsListingComponent from './components/CarListingComponent'

function App() {
  return (
    <div className="App container">
      <WelcomeComponent />
      <CarsListingComponent no="first"/>

    </div>
  );
}

export default App;
