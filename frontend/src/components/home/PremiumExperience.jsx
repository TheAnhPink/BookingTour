import './../../styles/home.css';

const features = [
    {
        icon: '🧭',
        title: 'Led by Experts',
        desc: 'Our local teams are part of the communities you’ll explore and know every detail.',
    },
    {
        icon: '🛎️',
        title: 'Industry-Leading Service',
        desc: 'Worry-free Travel Protection Plan, Private Chauffeur Service, and 24/7 support.',
    },
    {
        icon: '✨',
        title: 'Unmatched Tour Design',
        desc: 'Regionally based teams design immersive, inclusive tours at the best possible price.',
    },
];

export default function PremiumExperience() {
    return (
        <section className="section premium">
            <div className="container">
                <div className="section-header" style={{ justifyContent: 'center', textAlign: 'center' }}>
                    <div>
                        <h2>The Collette Premium Experience</h2>
                        <p>Led by Experts, Evolved by Travelers.</p>
                    </div>
                </div>

                <div className="premium-grid">
                    {features.map((f, idx) => (
                        <div key={idx} className="premium-item">
                            <div className="premium-icon">{f.icon}</div>
                            <h3>{f.title}</h3>
                            <p>{f.desc}</p>
                        </div>
                    ))}
                </div>
            </div>
        </section>
    );
}