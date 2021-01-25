import React from 'react';

class ListItem extends React.Component {

    render() {
        const { todo, index, deleteTask, duplicateTask, toggleTodoMarked } = this.props;
        return (
            <div style={{ boxShadow: "0px 0px 0px blue" }}
                class="d-flex flex-row justify-content-center list-group-item list-group-item-action my-1 col-md-6 mx-auto">
                <input class="checkbox my-auto"
                    type="checkbox"
                    checked={todo.completed}
                    onChange={() => toggleTodoMarked(index)} />

                <span class="mx-3 my-auto" style={todo.completed ? { textDecoration: 'line-through' } : { fontStyle: "bold" }}>
                    {todo.task}
                </span>


                <button class="btn btn-primary col-md-2" onClick={() => deleteTask(index)}>DELETE</button>
                <button class="btn btn-primary col-md-2" onClick={() => duplicateTask(index)}>DUPLICATE</button>

            </div>

        );
    }
}

export default ListItem;
