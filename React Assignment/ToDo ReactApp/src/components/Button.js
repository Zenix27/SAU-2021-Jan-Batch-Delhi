import React from 'react';

class Button extends React.Component {

    render() {

        const { ButtonValue, onClick, Class } = this.props;
        return (

            <button class={Class} onClick={onClick}> {ButtonValue} </button>

        );
    }
}

export default Button;