import { useRouteError } from "react-router-dom"

const ErrorPage = () => {
  const error = useRouteError();
  console.error(error);

  return (
    <div className="mx-auto p-3">
      <h1>Something happened!</h1>
      <p>Something happened.</p>
      <p>
        <i>{error.statusText || error.message}</i>
      </p>
    </div>
  )
}

export default ErrorPage;