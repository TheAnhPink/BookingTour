import { useState, useEffect } from 'react';

export default function useFetch(apiFunction) {
    const [data, setData] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        apiFunction()
            .then(res => {
                setData(res.data);
                setLoading(false);
            })
            .catch(err => {
                console.error(err);
                setLoading(false);
            });
    }, [apiFunction]);

    return { data, loading };
}