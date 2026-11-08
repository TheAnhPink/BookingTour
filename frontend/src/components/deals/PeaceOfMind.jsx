export default function PeaceOfMind() {
    const features = [
        { icon: "🛡️", title: "Cancel-for-Any-Reason Travel Protection", desc: "Flexibility to cancel up to 24 hours before departure." },
        { icon: "🚗", title: "Private Chauffeur Home-to-Airport", desc: "Door-to-door service for a stress-free start." },
        { icon: "📞", title: "Always There 24/7 Emergency Support", desc: "Peace of mind wherever you are." },
        { icon: "🧭", title: "Guided by Local In-Destination Experts", desc: "Authentic experiences with knowledgeable guides." }
    ];

    return (
        <section className="section peace-of-mind">
            <div className="container">
                <div className="section-header text-center">
                    <h2>Travel With Peace of Mind</h2>
                    <p>With the flexibility to cancel up to 24 hours before departure, private home-to-airport chauffeur service, and 24/7 emergency support, you can focus on what matters most — enjoying your trip.</p>
                </div>
                <div className="peace-grid">
                    {features.map((f, i) => (
                        <div key={i} className="peace-item">
                            <div className="peace-icon">{f.icon}</div>
                            <h4>{f.title}</h4>
                            <p>{f.desc}</p>
                        </div>
                    ))}
                </div>
            </div>
        </section>
    );
}