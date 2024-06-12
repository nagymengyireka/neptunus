import { useState } from "react";
import { Form, Modal, Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";

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
            <div className="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
                <div className="sm:mx-auto sm:w-full sm:max-w-sm">
                    <img
                        className="mx-auto h-20 w-auto"
                        src="../public/trident.png"
                        alt="Neptunus"
                    />
                    <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">
                        Register as a student
                    </h2>
                </div>
            </div>
            <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">

                <Form onSubmit={handleSubmit}>
                    <div className="space-y-12">
                        <div className="border-b border-gray-900/10 pb-12">
                            <div className="text-base font-semibold leading-7 text-gray-900">
                                <label htmlFor="firstName">First Name</label>
                                <input type="text" className="form-control" id="firstName" placeholder="Enter first name" value={firstName} onChange={(e) => setFirstName(e.target.value)} required />
                            </div>
                            <br></br>
                            <div className="text-base font-semibold leading-7 text-gray-900">
                                <label htmlFor="lastName">Last Name</label>
                                <input type="text" className="form-control" id="lastName" placeholder="Enter last name" value={lastName} onChange={(e) => setLastName(e.target.value)} required />
                            </div>

                        </div>
                        <div className="text-base font-semibold leading-7 text-gray-900">
                            <label htmlFor="password">Password</label>
                            <input type="password" className="form-control" id="password" placeholder="Enter password" value={password} onChange={(e) => setPassword(e.target.value)} minLength={6} required />
                        </div>
                        <div className="text-base font-semibold leading-7 text-gray-900">
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
                        <div className="mt-6 flex items-center justify-end gap-x-6">
                            <Link to='/login'>
                            <button type="button" className="text-sm font-semibold leading-6 text-gray-900">
                                Cancel
                            </button>
                            </Link>
                            <button
                                type="submit"
                                className="rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
                            >
                                Save
                            </button>
                        </div>
                    </div>
                </Form>
            </div>

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