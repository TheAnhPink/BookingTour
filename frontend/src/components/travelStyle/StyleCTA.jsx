import { Link } from 'react-router-dom';

export default function StyleCTA({ title }) {
    return (
        <section className="section style-cta">
            <div className="container" style={{ textAlign: 'center' }}>
                <h2>Ready to Explore?</h2>
                <p>Find your perfect {title.toLowerCase()} today.</p>
                <Link to="/find-your-tour" className="btn btn-primary btn-lg">View All Tours</Link>
            </div>
        </section>
    );
}