import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Form, Modal, Button } from "react-bootstrap";

function RegisterTeacher () {
    const navigate = useNavigate();
    const code = "notastudent";
    const [secret, setSecret] = useState('');
    const [allowed, setAllowed] = useState(false); 

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [name, setName] = useState('');
    const [dateOfBirth, setDateOfBirth] = useState('');
    const [gender, setGender] = useState('');

    const [showModal, setShowModal] = useState(false);
    const [modalMessage, setModalMessage] = useState('');
    const [isSuccessful, setIsSuccessful] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();

        const response = await fetch("/api/user/register/teacher", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username,
                password,
                name,
                dateOfBirth,
                gender
            })
        });

        if (response.ok) {
            setModalMessage(`You successfully created a teacher account!`);
            setIsSuccessful(true);
        } else {
            setModalMessage("Oh, oh. An unexpected error has occurred. Try again later.");
            setIsSuccessful(false);
        }

        setShowModal(true);
    }

    const handleModalClose = () => {
        setShowModal(false);
        if (isSuccessful) {
            navigate("/login/teacher");
        } else {
            navigate("/main");
        }
    }

    const handleLetIn = () => {
        if (secret === code) {
            setAllowed(true);
        } else {
            alert("Incorrect access code!\nYou are not authorized to access this page.");
        }
    }

    return (<>
    
    {allowed ? (
        <>
        <Form onSubmit={handleSubmit}>
            <div className="row">
                <div className="col">
                    <label htmlFor="name">Name</label>
                    <input type="text" className="form-control" id="name" placeholder="Enter your name" value={name} onChange={(e) => setName(e.target.value)} required />
                </div>
                <div className="col">
                    <label htmlFor="username">Username</label>
                    <input type="text" className="form-control" id="username" placeholder="Choose a username" value={username} onChange={(e) => setUsername(e.target.value)} required />
                </div>
            </div>
            <div className="form-group">
                <label htmlFor="password">Password</label>
                <input type="password" className="form-control" id="password" placeholder="Enter password" value={password} onChange={(e) => setPassword(e.target.value)} minLength={6} required />
                <small id="passwordHelp" className="form-text text-muted">Must be at least 6 characters long.</small>
            </div>
            <div className="form-group">
                <label htmlFor="dob">Date of Birth</label>
                <input type="date" className="form-control" id="dob" value={dateOfBirth} onChange={(e) => setDateOfBirth(e.target.value)} required />
            </div>
            <div className="form-check form-check-inline">
                <input className="form-check-input" type="radio" name="gender" id="gender1" value="MALE" checked={gender === "MALE"} onChange={(e) => setGender(e.target.value)} required />
                <label className="form-check-label" htmlFor="gender1">
                    Male
                </label>
            </div>
            <div className="form-check form-check-inline">
                <input className="form-check-input" type="radio" name="gender" id="gender2" value="FEMALE" checked={gender === "FEMALE"} onChange={(e) => setGender(e.target.value)} required />
                <label className="form-check-label" htmlFor="gender2">
                    Female
                </label>
            </div>
            <div className="form-group">
                <button type="submit">Create Teacher Account</button>
            </div>
        </Form>

        <Modal show={showModal} onHide={handleModalClose}>
            <Modal.Header closeButton>
                <Modal.Title>Account Creation Status</Modal.Title>
            </Modal.Header>
            <Modal.Body>{modalMessage}</Modal.Body>
            <Modal.Footer>
                <Button variant="primary" onClick={handleModalClose}>
                    OK
                </Button>
            </Modal.Footer>
        </Modal>
    </>
) : (
    <div>
        <Form onSubmit={handleLetIn}>
        <div className="form-group">
                <label htmlFor="secret">Access Code</label>
                <input type="password" className="form-control" id="secret" placeholder="Enter access code" value={secret} onChange={(e) => setSecret(e.target.value)} required/>
        </div>
        <Button type="submit" variant="secondary">Access Page</Button> 
        </Form>

    </div>
)}
    </>
    )
}

export default RegisterTeacher;