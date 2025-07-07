const ProductLineCard = ({ name, description, image }) => {
  return (
    <div className="p-4 border shadow rounded-md bg-white">
      {image && (
        <img
          src={image}
          alt={name}
          className="w-full h-40 object-cover rounded mb-3"
        />
      )}
      <h2 className="text-lg font-semibold text-blue-800">{name}</h2>
      <p className="text-sm text-gray-600 mt-2">{description}</p>
    </div>
  );
};

export default ProductLineCard;
