import HeroSection from '../components/home/HeroSection';
import FeaturedTours from '../components/home/FeaturedTours';
import WhatsNew from '../components/home/WhatsNew';
import PremiumExperience from '../components/home/PremiumExperience';
import ReviewsSection from '../components/home/ReviewsSection';
import HelpSection from '../components/home/HelpSection';

export default function Home() {
    return (
        <div className="home">
            <HeroSection />
            <FeaturedTours />
            <WhatsNew />
            <PremiumExperience />
            <ReviewsSection />
            <HelpSection />
        </div>
    );
}