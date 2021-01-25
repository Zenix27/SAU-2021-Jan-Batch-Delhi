import './App.css';
import React from 'react';
import InputText from './components/InputText.js';
import Button from './components/Button';
import List from "./components/List";

class App extends React.Component {

  state = {
    inputFieldValue: "",
    todoList: [{ task: "Show", completed: false }],
    filter: " " 
  };

  updateInputField = (event) => {
    this.setState({ inputFieldValue: event.target.value });
  }

  addTodo = () => {
    const { inputFieldValue, todoList } = this.state;
    let newTodos = [...todoList];
    if (inputFieldValue !== "") {
      newTodos.push({ task: inputFieldValue, completed: false });
      this.setState({ todoList: newTodos, inputFieldValue: "" });
    }
  }

  deleteTask = (index) => {
    const { todoList } = this.state;
    let tempArr = [...todoList];
    tempArr.splice(index, 1);
    this.setState({ todoList: tempArr });
  }

  duplicateTask = (index) => {
    const { todoList } = this.state;
    let tempArr = [...todoList];
    tempArr.push({ task: tempArr[index].task, completed: false })
    this.setState({ todoList: tempArr });
  }

  toggleTodoMarked = (index) => {
    const todos = this.state.todoList;
    let newTodos = [...todos];
    newTodos[index].completed = !newTodos[index].completed;
    this.setState({ todoList: newTodos });
  }

  displayAll = () => {
    this.setState({ filter: " " });
  }

  displayCompleted = () => {
    this.setState({ filter: "completed" });
  }

  displayPending = () => {
    this.setState({ filter: "pending" });
  }

  render() {
    return (
      <div class="d-flex flex-column justify-content-around align-content-center m-4 bg-light" style={{ fontFamily: "roboto" }}>
        <h2 class="text-center">Todo List</h2>
        <InputText value={this.state.inputFieldValue} onChange={this.updateInputField} placeholder="Type Task" />
        <div class="d-flex align-items-center flex-column">
          <Button ButtonValue="Add New Task" onClick={this.addTodo} Class="btn btn-primary col-md-2" />
          <Button ButtonValue="Show Tasks" onClick={this.displayAll} Class="btn btn-primary col-md-2" />
          <Button ButtonValue="Show Done" onClick={this.displayCompleted} Class="btn btn-primary col-md-2" />
          <Button ButtonValue="Show Pending" onClick={this.displayPending} Class="btn btn-primary col-md-2" />
        </div>

        <List todoList={this.state.todoList}
          filter={this.state.filter}
          deleteTask={this.deleteTask}
          duplicateTask={this.duplicateTask}
          toggleTodoMarked={this.toggleTodoMarked} />
      </div>
    );
  }
}

export default App;
