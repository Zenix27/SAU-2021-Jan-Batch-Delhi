import React from 'react';

class InputText extends React.Component {

    render() {

        const { value, onChange, placeholder } = this.props;

        return (
            <div class="form-group">
                <input
                    type="text"
                    value={value}
                    onChange={onChange}
                    placeholder={placeholder}
                    class="form-control col-md-3 mx-auto text-center font-weight-bold"
                    style={{ fontSize: 16 }}
                >
                </input>
            </div>
        );
    }
}

export default InputText;
