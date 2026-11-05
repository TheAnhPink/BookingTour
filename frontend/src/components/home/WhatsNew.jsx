import './../../styles/home.css';

export default function WhatsNew() {
    return (
        <section className="section whats-new">
            <div className="container">
                <div className="section-header">
                    <div>
                        <h2>Dive Into What's New</h2>
                        <p>Explore the latest deals and destinations.</p>
                    </div>
                    <a href="#" className="see-all">See All →</a>
                </div>

                <div className="whats-grid">
                    <div className="whats-card large">
                        <img src="https://picsum.photos/seed/new1/800/500" alt="New deal" />
                        <div className="whats-overlay">
                            <span className="whats-tag">New for 2026</span>
                            <h3>Japan: Land of the Rising Sun</h3>
                            <a href="#" className="btn btn-white btn-sm">Discover</a>
                        </div>
                    </div>

                    <div className="whats-col">
                        <div className="whats-card small">
                            <img src="https://picsum.photos/seed/new2/500/300" alt="Deal" />
                            <div className="whats-overlay">
                                <span className="whats-tag">Limited Offer</span>
                                <h4>Save 15% on European Tours</h4>
                            </div>
                        </div>
                        <div className="whats-card small">
                            <img src="https://picsum.photos/seed/new3/500/300" alt="Deal" />
                            <div className="whats-overlay">
                                <span className="whats-tag">Small Group</span>
                                <h4>Intimate Tours of Italy</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
}