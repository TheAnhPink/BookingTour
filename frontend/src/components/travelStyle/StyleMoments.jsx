export default function StyleMoments({ title, moments }) {
    if (!moments || moments.length === 0) return null; // Ẩn nếu không có data

    return (
        <section className="section style-moments">
            <div className="container">
                <h2>Moments That Make {title} Unforgettable</h2>
                <div className="moments-grid">
                    {moments.map((item, index) => (
                        <div key={index} className="moment-card">
                            <img src={item.image} alt={item.title} />
                            <div className="moment-info">
                                <span className="moment-duration">{item.duration}</span>
                                <h3>{item.title}</h3>
                                <p>{item.desc}</p>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </section>
    );
}