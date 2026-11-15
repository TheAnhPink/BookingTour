export default function StyleHero({ title, tagline, image }) {
    return (
        <section className="style-hero" style={{ backgroundImage: `url(${image})` }}>
            <div className="hero-overlay">
                <div className="container">
                    <h1>{title}</h1>
                    <p className="hero-tagline">{tagline}</p>
                </div>
            </div>
        </section>
    );
}