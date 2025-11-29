import { useState } from "react";
function Form(){
    const [name, setName] = React.useState('');
    const [email, setEmail] = React.useState('');
    const [pass, setPass] = React.useState('');
    return(
    <form>
        {name}
        {email}
        {pass}
        <div>
            <label>Name:</label>
            <input type="text" name="name"
            onChange={(e)=>setName(e.target.value)} />
        </div>

        <div>
            <label>Email:</label>
            <input type="text" name="email" 
             onChange={(e)=>setEmail(e.target.value)}/>
        </div>
        <div>
            <label>Password:</label>
            <input type="text" name="pass"
             onChange={(e)=>setPass(e.target.value)} />
        </div>
    </form>
    )
}
function FormComponent(){
  return (
    <form>
        <div>
            <label htmlFor="name">Name:</label>
            <input type="text" id="name" name="name" />
        </div>
    </form>   
  )
}
export default Form;