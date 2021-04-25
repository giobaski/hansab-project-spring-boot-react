import React from 'react'
import ReactDOM from 'react-dom'
import axios from "axios";

const { Component } = require("react");

class CarListingComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            users: [],
            cars: [],
            selectedUser: {}
        }
        this.retrieveAllUsersFromApi = this.retrieveAllUsersFromApi.bind(this)
        this.retrieveAllCarsFromApi = this.retrieveAllCarsFromApi.bind(this)
        this.userSelectedFromDropdown = this.userSelectedFromDropdown.bind(this)
        this.retrieveUserById = this.retrieveUserById.bind(this)


    }//endOfConstructor

    componentDidMount(){
        this.retrieveAllUsersFromApi()
        //Delete later
        this.retrieveAllCarsFromApi()
    }

    render(){

        return (
                <div>
                    <div class="dropdown">
                    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
                         {/* {this.state.selectedUser ? this.state.selectedUser.name : "Select a User"} */}
                         Select a User
                    </button>
                    <div class="dropdown-menu">
                        {
                            this.state.users.map(
                                user => 
                            <button key={user.id} class="dropdown-item" onClick = {()=>this.userSelectedFromDropdown(user.id)}>{user.name}</button>
                            )
                        }
                        
                    </div>
                    </div>
            

                <h2>List of Cars</h2>
     
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Make</th>
                                <th>Model</th>
                                <th>Numberplate</th>
                                <th>User</th>
                            </tr>
                        </thead>

                            {this.state.cars.map(
                                car=> 
                                <tbody>
                                    <tr key={car.id}>
                                        <td>{car.make}</td>
                                        <td>{car.model}</td>
                                        <td>{car.numberplate}</td>
                                        <td>{car.user}</td>
                                    </tr>
                                </tbody>
                                ) 
                             }
                    </table>

                    {/* <h3>Selected user:{this.state.selectedUser.name}  </h3>  */}
                </div>
        )
    }//EndOfRender


    retrieveAllUsersFromApi(){
        return axios.get("http://localhost:8080/api/users")
            .then(response => this.setState({
                users: response.data
            }))
            .catch()
        
    }

    retrieveAllCarsFromApi(){
        return axios.get("http://localhost:8080/api/cars")
            .then(response => this.setState({
                cars: response.data
            }))
            .catch()
        
    }

    
    retrieveUserById(id){
        return axios.get("http://localhost:8080/api/users/" + id)
            .then(response => this.setState(
                    {
                    cars: response.data.cars,
                    selectedUser: response.data
                    }
                )
            )
            .catch()
    }

    userSelectedFromDropdown(id){
        this.retrieveUserById(id)
        // this.forceUpdate()
    }




}

export default CarListingComponent
