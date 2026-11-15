export default function StyleFeatures({ title, features }) {
    return (
        <section className="section style-features">
            <div className="container">
                <h2>Why Travelers Love Our {title}</h2>
                <div className="features-grid">
                    {features.map((item, index) => (
                        <div key={index} className="feature-card">
                            <div className="feature-icon">{item.icon}</div>
                            <h3>{item.title}</h3>
                            <p>{item.desc}</p>
                        </div>
                    ))}
                </div>
            </div>
        </section>
    );
}