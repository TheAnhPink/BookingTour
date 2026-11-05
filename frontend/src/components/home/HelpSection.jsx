import './../../styles/home.css';

export default function HelpSection() {
    return (
        <section className="section help">
            <div className="container help-inner">
                <div className="help-text">
                    <h2>Need Help?</h2>
                    <p>Our travel experts are ready to make planning easy.</p>
                </div>
                <div className="help-actions">
                    <button className="btn btn-primary">Contact Us</button>
                    <button className="btn btn-outline">Call 1-800-123-4567</button>
                </div>
            </div>
        </section>
    );
}