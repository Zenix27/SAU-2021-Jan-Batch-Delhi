import React from 'react';
import ListItem from "./ListItem";

class List extends React.Component {
    render() {
        const { todoList, filter, deleteTask, duplicateTask, toggleTodoMarked } = this.props;
        let showToDos = [];

        if (filter === " ") {
            showToDos = [...todoList];
        }
        else if (filter === "completed") {
            for (let todo of todoList) {
                if (todo.completed) showToDos.push(todo);
            }
        }
        else if (filter === "pending") {
            for (let todo of todoList) {
                if (!todo.completed) showToDos.push(todo);
            }
        }

        return (
            <div class="d-flex flex-column justify-content-center align-content-center list-group">
                <h4 class="text-center font-weight-bold mt-4" style={{ color: "gray" }}>{filter.toUpperCase()} TO DO</h4>
                {showToDos ? showToDos.map(
                    (value, index) => {
                        return <ListItem key={index}
                            todo={value}
                            index={index}
                            deleteTask={deleteTask}
                            duplicateTask={duplicateTask}
                            toggleTodoMarked={toggleTodoMarked} />
                    }
                ) : null
                }
            </div>
        );
    }
}


export default List;