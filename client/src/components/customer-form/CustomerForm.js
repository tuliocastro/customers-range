import React, { Component } from 'react';
import './CustomerForm.scss';
import * as classNames from 'classnames';

export default class CustomerForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            file: null
        }
    }

    onFileSelect = (e) => {
        let file = e.target.files[0];
        this.setState({ file: file });
        this.props.callback(file);
    }

    chooseFile = () => {
        document.getElementById('input-file').click();
    }

    render() {

        var formClassNames = classNames({
            'CustomerFormFile': true,
            'has-file': this.state.file,
        });

        return (
            <form className={formClassNames} onClick={this.chooseFile}>
                <label>Load customer file</label>
                <input id="input-file" type="file" onChange={this.onFileSelect} />
            </form>
        )
    }
}
