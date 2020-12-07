import React, {Component} from 'react';
import {getProject} from "../../actions/projectActions";
import PropTypes from "prop-types";
import {connect} from "react-redux";
import classnames from "classnames";
import mapStateToProps from "react-redux/lib/connect/mapStateToProps";

class UpdateProject extends Component {
    componentDidMount() {
        const {id}=this.props.match.params;
        this.props.getProject(id,this.props.history);

    }

    render() {
        return (
            <div>
                <div className="project">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-8 m-auto">
                                <h5 className="display-4 text-center">Update Project form</h5>
                                <hr/>
                                <form>
                                    <div className="form-group">
                                        <input type="text" className="form-control form-control-lg "
                                               placeholder="Project Name"/>
                                    </div>
                                    <div className="form-group">
                                        <input type="text" className="form-control form-control-lg"
                                               placeholder="Unique Project ID"
                                               disabled/>
                                    </div>
                                  {/*  <!-- disabled for Edit Only!! remove "disabled" for the Create operation -->*/}
                                    <div className="form-group">
                                        <textarea className="form-control form-control-lg"
                                                  placeholder="Project Description"></textarea>
                                    </div>
                                    <h6>Start Date</h6>
                                    <div className="form-group">
                                        <input type="date" className="form-control form-control-lg" name="start_date"/>
                                    </div>
                                    <h6>Estimated End Date</h6>
                                    <div className="form-group">
                                        <input type="date" className="form-control form-control-lg" name="end_date"/>
                                    </div>

                                    <input type="submit" className="btn btn-primary btn-block mt-4"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
UpdateProject.propTyps={
    getProject:PropTypes.func.isRequired,
    project:PropTypes.object.isRequired
}
const mapStateToPropsUpdate=(state)=>({
    project:state.project.project
})
export default connect(mapStateToPropsUpdate,{getProject})(UpdateProject);