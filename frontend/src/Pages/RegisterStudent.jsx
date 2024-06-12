import { useState } from "react";
import { Form, Modal, Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

function RegisterStudent() {
    const navigate = useNavigate();

    const [password, setPassword] = useState('');
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [dateOfBirth, setDateOfBirth] = useState('');
    const [gender, setGender] = useState('');

    const [showModal, setShowModal] = useState(false);
    const [modalMessage, setModalMessage] = useState('');
    const [isSuccessful, setIsSuccessful] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();

        const response = await fetch("/api/user/register/student", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                password,
                lastName,
                firstName,
                dateOfBirth,
                gender
            })
        });

        if (response.ok) {
            const username = await response.text();
            setModalMessage(`You successfully signed up! <br> Your username is: ${username}`);
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
            navigate("/login");
        } else {
            navigate("/main");
        }
    }

    return (
        <>
            <Form onSubmit={handleSubmit}>
                <div className="row">
                    <div className="col">
                        <label htmlFor="firstName">First Name</label>
                        <input type="text" className="form-control" id="firstName" placeholder="Enter first name" value={firstName} onChange={(e) => setFirstName(e.target.value)} required />
                    </div>
                    <div className="col">
                        <label htmlFor="lastName">Last Name</label>
                        <input type="text" className="form-control" id="lastName" placeholder="Enter last name" value={lastName} onChange={(e) => setLastName(e.target.value)} required />
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
                    <button type="submit">Register</button>
                </div>
            </Form>

            <Modal show={showModal} onHide={handleModalClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Registration Status</Modal.Title>
                </Modal.Header>
                <Modal.Body dangerouslySetInnerHTML={{ __html: modalMessage }} />
                <Modal.Footer>
                    <Button variant="primary" onClick={handleModalClose}>
                        OK
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    )
}

export default RegisterStudent;