import React, { Component } from "react";
import {Link} from "react-router-dom";
class Header extends Component {
  render() {
    return (
      //Navbar Component
      <div>
        <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
          <div className="container">
            <Link className="navbar-brand" to="/dashboard">
              Personal Project Management Tool
            </Link>
            <button
              className="navbar-toggler"
              type="button"
              data-toggle="collapse"
              data-target="#mobile-nav"
            >
              <span className="navbar-toggler-icon" />
            </button>

            <div className="collapse navbar-collapse" id="mobile-nav">
              <ul className="navbar-nav mr-auto">
                <li className="nav-item">
                  <Link className="nav-link" to="/dashboard">
                    Dashboard
                  </Link>
                </li>
              </ul>

              <ul className="navbar-nav ml-auto">
                <li className="nav-item">
                  <Link className="btn btn-lg btn-primary mr-2 " to={"/register"}>
                    Sign Up
                  </Link>
                </li>
                <li>
                <Link className="btn btn-lg btn-primary mr-2 " to={"/login"}>
                  Log in
                </Link>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    );
  }
}

export default Header;
