package moe.queery.needle.math;

public final class Polynomials {
    public static float lerp(final float min, final float max, final float delta) {
        return (1 - delta) * min + delta * max;
    }

    public static float unlerp(final float min, final float max, final float delta) {
        return (delta - min) / (max - min); // TODO: maybe reverse it properly? xd ~lucy
    }

    public static float terp(final float xi, final float x, final float y) {
        final float N = x; // HOW TF DO I COUNT THE LENGTH OF THIS SHI~
        return .0F;
        // TODO: ...
        /* src: https://en.wikipedia.org/wiki/Trigonometric_interpolation
            function P = triginterp(xi,x,y)
            N = length(x);
            h = 2/N;
            scale = (x(2)-x(1)) / h;
            x = x/scale;  xi = xi/scale;
            P = zeros(size(xi));
            for k = 1:N
            P = P + y(k)*trigcardinal(xi-x(k),N);
            end
            function tau = trigcardinal(x,N)
            ws = warning('off','MATLAB:divideByZero');
            if rem(N,2)==1   % odd
            tau = sin(N*pi*x/2) ./ (N*sin(pi*x/2));
            else             % even
            tau = sin(N*pi*x/2) ./ (N*tan(pi*x/2));
            end
            warning(ws)
            tau(x==0) = 1;
        */
    }
}
