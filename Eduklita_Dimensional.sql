PGDMP     8                    y            Eduklita_Dimensional    12.6    12.6     !           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            "           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            #           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            $           1262    25161    Eduklita_Dimensional    DATABASE     �   CREATE DATABASE "Eduklita_Dimensional" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Ecuador.1252' LC_CTYPE = 'Spanish_Ecuador.1252';
 &   DROP DATABASE "Eduklita_Dimensional";
                postgres    false            �            1259    25162 	   dim_fecha    TABLE     \   CREATE TABLE public.dim_fecha (
    sk_fecha integer NOT NULL,
    anio integer NOT NULL
);
    DROP TABLE public.dim_fecha;
       public         heap    postgres    false            �            1259    25177    dim_niveles_educacion    TABLE     �   CREATE TABLE public.dim_niveles_educacion (
    sk_niveles_educacion integer NOT NULL,
    pk_nivel integer,
    descripcion character varying(10),
    valido_desde date,
    valido_hasta date,
    version integer NOT NULL
);
 )   DROP TABLE public.dim_niveles_educacion;
       public         heap    postgres    false            �            1259    25172    dim_provincia    TABLE       CREATE TABLE public.dim_provincia (
    sk_provincia integer NOT NULL,
    pk_id_provincia integer,
    nombre_provincia character varying(50),
    capital character varying(50),
    valido_desde date,
    valido_hasta date,
    version integer NOT NULL
);
 !   DROP TABLE public.dim_provincia;
       public         heap    postgres    false            �            1259    25167    dim_tipo_educacion    TABLE     �   CREATE TABLE public.dim_tipo_educacion (
    sk_tipo_educacion integer NOT NULL,
    version integer NOT NULL,
    valido_hasta date,
    pk_id_tipo integer,
    descripcion character varying(10),
    valido_desde date
);
 &   DROP TABLE public.dim_tipo_educacion;
       public         heap    postgres    false            �            1259    25182    fact_educacion    TABLE     7  CREATE TABLE public.fact_educacion (
    sk_niveles_educacion integer NOT NULL,
    sk_tipo_educacion integer NOT NULL,
    sk_provincia integer NOT NULL,
    sk_fecha integer NOT NULL,
    total numeric,
    alumnos integer,
    pib numeric,
    remuneracion numeric,
    renta numeric,
    contribucion numeric,
    prestaciones numeric,
    otras_transferencias numeric,
    transferencia numeric,
    produccion numeric,
    impuestos numeric,
    otros_impuestos numeric,
    consumo numeric,
    gasto numeric,
    formacion numeric,
    existencias numeric
);
 "   DROP TABLE public.fact_educacion;
       public         heap    postgres    false                      0    25162 	   dim_fecha 
   TABLE DATA           3   COPY public.dim_fecha (sk_fecha, anio) FROM stdin;
    public          postgres    false    202   {                  0    25177    dim_niveles_educacion 
   TABLE DATA           �   COPY public.dim_niveles_educacion (sk_niveles_educacion, pk_nivel, descripcion, valido_desde, valido_hasta, version) FROM stdin;
    public          postgres    false    205   �                  0    25172    dim_provincia 
   TABLE DATA           �   COPY public.dim_provincia (sk_provincia, pk_id_provincia, nombre_provincia, capital, valido_desde, valido_hasta, version) FROM stdin;
    public          postgres    false    204   :!                 0    25167    dim_tipo_educacion 
   TABLE DATA           }   COPY public.dim_tipo_educacion (sk_tipo_educacion, version, valido_hasta, pk_id_tipo, descripcion, valido_desde) FROM stdin;
    public          postgres    false    203   �#                 0    25182    fact_educacion 
   TABLE DATA           $  COPY public.fact_educacion (sk_niveles_educacion, sk_tipo_educacion, sk_provincia, sk_fecha, total, alumnos, pib, remuneracion, renta, contribucion, prestaciones, otras_transferencias, transferencia, produccion, impuestos, otros_impuestos, consumo, gasto, formacion, existencias) FROM stdin;
    public          postgres    false    206    $       �
           2606    25166    dim_fecha dim_fecha_pk 
   CONSTRAINT     Z   ALTER TABLE ONLY public.dim_fecha
    ADD CONSTRAINT dim_fecha_pk PRIMARY KEY (sk_fecha);
 @   ALTER TABLE ONLY public.dim_fecha DROP CONSTRAINT dim_fecha_pk;
       public            postgres    false    202            �
           2606    25181 .   dim_niveles_educacion dim_niveles_educacion_pk 
   CONSTRAINT     ~   ALTER TABLE ONLY public.dim_niveles_educacion
    ADD CONSTRAINT dim_niveles_educacion_pk PRIMARY KEY (sk_niveles_educacion);
 X   ALTER TABLE ONLY public.dim_niveles_educacion DROP CONSTRAINT dim_niveles_educacion_pk;
       public            postgres    false    205            �
           2606    25176    dim_provincia dim_provincia_pk 
   CONSTRAINT     f   ALTER TABLE ONLY public.dim_provincia
    ADD CONSTRAINT dim_provincia_pk PRIMARY KEY (sk_provincia);
 H   ALTER TABLE ONLY public.dim_provincia DROP CONSTRAINT dim_provincia_pk;
       public            postgres    false    204            �
           2606    25171 (   dim_tipo_educacion dim_tipo_educacion_pk 
   CONSTRAINT     u   ALTER TABLE ONLY public.dim_tipo_educacion
    ADD CONSTRAINT dim_tipo_educacion_pk PRIMARY KEY (sk_tipo_educacion);
 R   ALTER TABLE ONLY public.dim_tipo_educacion DROP CONSTRAINT dim_tipo_educacion_pk;
       public            postgres    false    203            �
           2606    25186     fact_educacion fact_educacion_pk 
   CONSTRAINT     �   ALTER TABLE ONLY public.fact_educacion
    ADD CONSTRAINT fact_educacion_pk PRIMARY KEY (sk_niveles_educacion, sk_tipo_educacion, sk_provincia, sk_fecha);
 J   ALTER TABLE ONLY public.fact_educacion DROP CONSTRAINT fact_educacion_pk;
       public            postgres    false    206    206    206    206            �
           2606    25187 *   fact_educacion dim_fecha_fact_educacion_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.fact_educacion
    ADD CONSTRAINT dim_fecha_fact_educacion_fk FOREIGN KEY (sk_fecha) REFERENCES public.dim_fecha(sk_fecha);
 T   ALTER TABLE ONLY public.fact_educacion DROP CONSTRAINT dim_fecha_fact_educacion_fk;
       public          postgres    false    202    2703    206            �
           2606    25202 6   fact_educacion dim_niveles_educacion_fact_educacion_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.fact_educacion
    ADD CONSTRAINT dim_niveles_educacion_fact_educacion_fk FOREIGN KEY (sk_niveles_educacion) REFERENCES public.dim_niveles_educacion(sk_niveles_educacion);
 `   ALTER TABLE ONLY public.fact_educacion DROP CONSTRAINT dim_niveles_educacion_fact_educacion_fk;
       public          postgres    false    2709    205    206            �
           2606    25197 .   fact_educacion dim_provincia_fact_educacion_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.fact_educacion
    ADD CONSTRAINT dim_provincia_fact_educacion_fk FOREIGN KEY (sk_provincia) REFERENCES public.dim_provincia(sk_provincia);
 X   ALTER TABLE ONLY public.fact_educacion DROP CONSTRAINT dim_provincia_fact_educacion_fk;
       public          postgres    false    204    2707    206            �
           2606    25192 3   fact_educacion dim_tipo_educacion_fact_educacion_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.fact_educacion
    ADD CONSTRAINT dim_tipo_educacion_fact_educacion_fk FOREIGN KEY (sk_tipo_educacion) REFERENCES public.dim_tipo_educacion(sk_tipo_educacion);
 ]   ALTER TABLE ONLY public.fact_educacion DROP CONSTRAINT dim_tipo_educacion_fact_educacion_fk;
       public          postgres    false    203    2705    206               ?   x�̹  ���+���c����J4)�N��*ݒ[#ȑ�@�h��Zh��%gd��%}F��         `   x�3�4�(��M,�L�4200�50" ��@��H�ؐӐˈӈ385�4/�2cNc��҂Ԣ��"��8c�Ȑ�� ��� �����<F��� �z!�         M  x����n�@���S������(�"�	�*���`#�%�ކȡ��뿴i��z�_fm��wfg~A�&�g��ʙߏ�������� 1(��*���t���jk�C
i��/����颱�E@�|/i�˼�VVtD#���!S5_=J��!��bLc��V������jg�c�i^z��%�{.�hB	͛CQs������RJw\v�#�TCk]ԭ�����(o��R�p������ϫ���E�=����>㺶g#���\�\H�B5�c��$���^�{v�䊳��
)�d��0"�P{O\��2��SY1&h�GE����}L�C]�%6D����lr�m��SkpBК��/���K:%h-�����k�����=�Tٛ�f���(܋���� ��-�G�i�+>]�b�����Г��!��J'�z;!	�`��^{�4A��e��\ov+�<X�|z^}^�y�I}�=J���o�aU$�?9���@R�Q?�� "`;$��8���@"c!fd|����[8��8��I�98���A?�f��0��`3�&4��`"3�fd�����\:��̡�I���3�_��oY쾿         Y   x�3�4�4206�54�56r�J��LN�����"#΀�̲�5@51~p�e�chi	7(lhi` Un�*m�&���� ܠJ         �  x�ŝ[nI�[w��ՙ������3�������a��aGt�qXXZ/�F/���şZ�'Kg�u��YwYm�k7��b��Zim�K-1c� ��h�� W1J���uX��B]�vPQ-԰P��
���M��	�6��&X�DK�hi-m��M����6��&Z�D��t���j��Kt����Xqk�5��r�X�|bͧ�8;=���n�1�cÃm,<Xz��J�S)x*O��=���R�T��J�S)z*EO����ל<��1�3��9�p��=�C�3q�K��y��q�SԾ+or\یh���y���	���X	��g<Y1#-��	�#�s$x�ϑ�9<g��L�	�3�s&x�ϙ�93��k���z�m�u�h�״W�NWZ���Մ{��BNhr��	r�!wr�!wr�)w�r�)w�r�)w�r�)w�r��_����^&�kh�1�:Z��c^����䄭&<�%)!�&'@N�� wr�!wr�!w�r�)w�r�)w�r�)w�r�)w��u���e��N���.��~�KR���ՄǼ$%�����	��NC�4�NC�4�NS�4�NS�4�NS�4�NS�4�NS�Nߟ���?�kg˽�Q��?�40�S�XzĖ#�:i�G4=z�������������M����M����M����M��LX��}�#x��ʱ�=��;�s�1���Gl9�1Gi�G4=z�������������M����M����M����M��LX��~��eĜ�&��F��?#���-G|��zD�#�GP�����������M����M����M����M����̈́���x�{;�ȸ�S�z�<GiS�XzĖ#s�zD�#�GP�����������M����M����M����M����̈́���|�[^�G���8�|����s<Rb�L`���3Ô�	���@�	�ϑ�9<G��H�	�3�s&x�ϙ�9<g��L�����^fD�2�n�-�a>�O�EL=b�[��>��zD�#�GP�����������M����M����M����M����̈́����u�٪�6׼?R�1��qSZ��#�����E�����#�vCo7�vCo7�vSo7�vSo7�vSo7�vSo7�vSm7�;��/���B���3��k�UZ=�σ�5�{�����{��|��`��-����dcÃm,<Xz��J�S)x*O��=���R�T��J�S)z*EO��M���1�o��:�h�z��qV��p�8�y��oi���t�P�����__H����,TX��P-m��M��	�6��&Z�DK�hi-m��M����6��&z榯�?���ޮ�c�杙��`.�e�������t�t@�����@�B�m(P:��"�Q$8�G��(E��Ht��"�Q$:�DG��(-3�ױ+�y���uF�^�_��>GD+;�i�� ��N�NuY��A�>�5�j�Pa��B��	�6��&X�K�hi-m��M����6��&Z�DK�虛��8�MC�!�p�d�<�v��X�̾�y�1��ΆNt9�� �>�m.4�����(E��Hp	�"�Q$:�DG��(E��Ht��"�2#ݯg�(�"qn�k�6������<�j��e���ө�B]�vP���3�j�Pa��B��	�6��&X�K�hi-m��M����6��&Z�DK�虛��Z�4���h���3��ڼ��~�gu�<�=����i�.u;��y8�j�Pa��B��	�6��&X�K�hi-m��M����6��&Z�DK�虛�����5���e_oB��3x�G���un�q~��֧q8:��n�q\D64�����(E��Hp	�"�Q$:�DG��(E��Ht��"�Q��+�(=�n���m���\�eļ��b��K�ظ�H\���g�9���������Ƹ�N�V>�?�����=���NvY��}�q�?1��}���e�f`ٷ�m�>>M�ǆ��
���e����e`=���R�T
�J�S)z*��J������_�q     