/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;


/// Represents a class type in Objective C.
///
/// Every Objective C type is a combination of a base type, a set of
/// type arguments (optional, for parameterized classes) and a list of
/// protocols.
///
/// Given the following declarations:
/// \code
///   \@class C<T>;
///   \@protocol P;
/// \endcode
///
/// 'C' is an ObjCInterfaceType C.  It is sugar for an ObjCObjectType
/// with base C and no protocols.
///
/// 'C<P>' is an unspecialized ObjCObjectType with base C and protocol list [P].
/// 'C<C*>' is a specialized ObjCObjectType with type arguments 'C*' and no 
/// protocol list.
/// 'C<C*><P>' is a specialized ObjCObjectType with base C, type arguments 'C*',
/// and protocol list [P].
///
/// 'id' is a TypedefType which is sugar for an ObjCObjectPointerType whose
/// pointee is an ObjCObjectType with base BuiltinType::ObjCIdType
/// and no protocols.
///
/// 'id<P>' is an ObjCObjectPointerType whose pointee is an ObjCObjectType
/// with base BuiltinType::ObjCIdType and protocol list [P].  Eventually
/// this should get its own sugar class to better represent the source.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4727,
 FQN="clang::ObjCObjectType", NM="_ZN5clang14ObjCObjectTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ObjCObjectTypeE")
//</editor-fold>
public class ObjCObjectType extends /*public*/ Type {
  // ObjCObjectType.NumTypeArgs - the number of type arguments stored
  // after the ObjCObjectPointerType node.
  // ObjCObjectType.NumProtocols - the number of protocols stored
  // after the type arguments of ObjCObjectPointerType node.
  //
  // These protocols are those written directly on the type.  If
  // protocol qualifiers ever become additive, the iterators will need
  // to get kindof complicated.
  //
  // In the canonical object type, these are sorted alphabetically
  // and uniqued.
  
  /// Either a BuiltinType or an InterfaceType or sugar for either.
  private QualType BaseType;
  
  /// Cached superclass type.
  private /*mutable */PointerBoolPair</*const*/ ObjCObjectType /*P*/ > CachedSuperClassType;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getProtocolStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4747,
   FQN="clang::ObjCObjectType::getProtocolStorage", NM="_ZNK5clang14ObjCObjectType18getProtocolStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType18getProtocolStorageEv")
  //</editor-fold>
  private type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> getProtocolStorage$Const() /*const*/ {
    return ((/*const_cast*/ObjCObjectType /*P*/ )(this)).getProtocolStorage();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getTypeArgStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4915,
   FQN="clang::ObjCObjectType::getTypeArgStorage", NM="_ZN5clang14ObjCObjectType17getTypeArgStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ObjCObjectType17getTypeArgStorageEv")
  //</editor-fold>
  private /*inline*/ type$ptr<QualType /*P*/> getTypeArgStorage() {
    return $TypeArgs;//((type$ptr<QualType /*P*/> )reinterpret_cast(type$ptr.class, ((/*static_cast*/ObjCObjectTypeImpl /*P*/ )(this)) + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getTypeArgStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4752,
   FQN="clang::ObjCObjectType::getTypeArgStorage", NM="_ZNK5clang14ObjCObjectType17getTypeArgStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType17getTypeArgStorageEv")
  //</editor-fold>
  private /*const*/type$ptr<QualType /*P*/> getTypeArgStorage$Const() /*const*/ {
    return ((/*const_cast*/ObjCObjectType /*P*/ )(this)).getTypeArgStorage();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getProtocolStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4919,
   FQN="clang::ObjCObjectType::getProtocolStorage", NM="_ZN5clang14ObjCObjectType18getProtocolStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ObjCObjectType18getProtocolStorageEv")
  //</editor-fold>
  private /*inline*/ type$ptr<ObjCProtocolDecl /*P*/ /*P*/> getProtocolStorage() {
    return $Protocols;//((type$ptr<ObjCProtocolDecl /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, getTypeArgStorage().$add(Unnamed_field.ObjCObjectTypeBits.NumTypeArgs)));
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::ObjCObjectType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*sizeof*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 535,
   FQN="clang::ObjCObjectType::ObjCObjectType", NM="_ZN5clang14ObjCObjectTypeC1ENS_8QualTypeES1_N4llvm8ArrayRefIS1_EENS3_IPNS_16ObjCProtocolDeclEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ObjCObjectTypeC1ENS_8QualTypeES1_N4llvm8ArrayRefIS1_EENS3_IPNS_16ObjCProtocolDeclEEEb")
  //</editor-fold>
  protected ObjCObjectType(QualType Canonical, QualType Base, 
      ArrayRef<QualType> typeArgs, 
      ArrayRef<ObjCProtocolDecl /*P*/ > protocols, 
      boolean isKindOf) {
    // : Type(ObjCObject, Canonical, Base->isDependentType(), Base->isInstantiationDependentType(), Base->isVariablyModifiedType(), Base->containsUnexpandedParameterPack()), BaseType(Base), CachedSuperClassType() 
    //START JInit
    super(TypeClass.ObjCObject, new QualType(Canonical), Base.$arrow().isDependentType(), 
        Base.$arrow().isInstantiationDependentType(), 
        Base.$arrow().isVariablyModifiedType(), 
        Base.$arrow().containsUnexpandedParameterPack());
    this.BaseType = new QualType(Base);
    this.CachedSuperClassType = new PointerBoolPair</*const*/ ObjCObjectType /*P*/ >();
    //END JInit
    Unnamed_field.ObjCObjectTypeBits.IsKindOf = isKindOf;
    
    Unnamed_field.ObjCObjectTypeBits.NumTypeArgs = $uint2uint_7bits(typeArgs.size());
    assert (getTypeArgsAsWritten().size() == typeArgs.size()) : "bitfield overflow in type argument count";
    Unnamed_field.ObjCObjectTypeBits.NumProtocols = $uint2uint_6bits(protocols.size());
    assert (getNumProtocols() == protocols.size()) : "bitfield overflow in protocol count";
    $TypeArgs = create_type$ptr(new QualType[typeArgs.size()]);
    if (!typeArgs.empty()) {
      memcpy(getTypeArgStorage(), typeArgs.data(), 
          typeArgs.size() * (true ? /*JAVA*/1 : $sizeof_QualType()), false);
    }
    $Protocols = create_type$ptr(new ObjCProtocolDecl[protocols.size()]);
    if (!protocols.empty()) {
      memcpy(getProtocolStorage(), protocols.data(), 
          protocols.size() * (true ? /*JAVA*/1 : $sizeof_ptr(/*ObjCProtocolDecl  */)), true);
    }
    
    for (QualType typeArg : typeArgs) {
      if (typeArg.$arrow().isDependentType()) {
        setDependent();
      } else if (typeArg.$arrow().isInstantiationDependentType()) {
        setInstantiationDependent();
      }
      if (typeArg.$arrow().containsUnexpandedParameterPack()) {
        setContainsUnexpandedParameterPack();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::Nonce_ObjCInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4764,
   FQN="clang::ObjCObjectType::Nonce_ObjCInterface", NM="_ZN5clang14ObjCObjectType19Nonce_ObjCInterfaceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ObjCObjectType19Nonce_ObjCInterfaceE")
  //</editor-fold>
  protected enum Nonce_ObjCInterface implements Native.ComparableLower {
    Nonce_ObjCInterface(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Nonce_ObjCInterface valueOf(int val) {
      Nonce_ObjCInterface out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Nonce_ObjCInterface[] VALUES;
      private static final Nonce_ObjCInterface[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Nonce_ObjCInterface kind : Nonce_ObjCInterface.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Nonce_ObjCInterface[min < 0 ? (1-min) : 0];
        VALUES = new Nonce_ObjCInterface[max >= 0 ? (1+max) : 0];
        for (Nonce_ObjCInterface kind : Nonce_ObjCInterface.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Nonce_ObjCInterface(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Nonce_ObjCInterface)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Nonce_ObjCInterface)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::ObjCObjectType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4765,
   FQN="clang::ObjCObjectType::ObjCObjectType", NM="_ZN5clang14ObjCObjectTypeC1ENS0_19Nonce_ObjCInterfaceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ObjCObjectTypeC1ENS0_19Nonce_ObjCInterfaceE")
  //</editor-fold>
  protected ObjCObjectType( Nonce_ObjCInterface $Prm0) {
    // : Type(ObjCInterface, QualType(), false, false, false, false), BaseType(QualType(this_(), 0)), CachedSuperClassType() 
    //START JInit
    super(TypeClass.ObjCInterface, new QualType(), false, false, false, false);
    this.BaseType = new QualType(this_(), 0);
    this.CachedSuperClassType = new PointerBoolPair</*const*/ ObjCObjectType /*P*/ >();
    //END JInit
    Unnamed_field.ObjCObjectTypeBits.NumProtocols = $uint2uint_6bits(0);
    Unnamed_field.ObjCObjectTypeBits.NumTypeArgs = $uint2uint_7bits(0);
    Unnamed_field.ObjCObjectTypeBits.IsKindOf = false;
    $TypeArgs = create_type$ptr();
    $Protocols = create_type$ptr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::computeSuperClassTypeSlow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1376,
   FQN="clang::ObjCObjectType::computeSuperClassTypeSlow", NM="_ZNK5clang14ObjCObjectType25computeSuperClassTypeSlowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType25computeSuperClassTypeSlowEv")
  //</editor-fold>
  protected void computeSuperClassTypeSlow() /*const*/ {
    // Retrieve the class declaration for this type. If there isn't one
    // (e.g., this is some variant of "id" or "Class"), then there is no
    // superclass type.
    ObjCInterfaceDecl /*P*/ classDecl = getInterface();
    if (!(classDecl != null)) {
      CachedSuperClassType.setInt(true);
      return;
    }
    
    // Extract the superclass type.
    /*const*/ ObjCObjectType /*P*/ superClassObjTy = classDecl.getSuperClassType();
    if (!(superClassObjTy != null)) {
      CachedSuperClassType.setInt(true);
      return;
    }
    
    ObjCInterfaceDecl /*P*/ superClassDecl = superClassObjTy.getInterface();
    if (!(superClassDecl != null)) {
      CachedSuperClassType.setInt(true);
      return;
    }
    
    // If the superclass doesn't have type parameters, then there is no
    // substitution to perform.
    QualType superClassType/*J*/= new QualType(superClassObjTy, 0);
    ObjCTypeParamList /*P*/ superClassTypeParams = superClassDecl.getTypeParamList();
    if (!(superClassTypeParams != null)) {
      CachedSuperClassType.setPointerAndInt(superClassType.$arrow().castAs(ObjCObjectType.class), true);
      return;
    }
    
    // If the superclass reference is unspecialized, return it.
    if (superClassObjTy.isUnspecialized()) {
      CachedSuperClassType.setPointerAndInt(superClassObjTy, true);
      return;
    }
    
    // If the subclass is not parameterized, there aren't any type
    // parameters in the superclass reference to substitute.
    ObjCTypeParamList /*P*/ typeParams = classDecl.getTypeParamList();
    if (!(typeParams != null)) {
      CachedSuperClassType.setPointerAndInt(superClassType.$arrow().castAs(ObjCObjectType.class), true);
      return;
    }
    
    // If the subclass type isn't specialized, return the unspecialized
    // superclass.
    if (isUnspecialized()) {
      QualType unspecializedSuper = classDecl.getASTContext().getObjCInterfaceType(superClassObjTy.getInterface());
      CachedSuperClassType.setPointerAndInt(unspecializedSuper.$arrow().castAs(ObjCObjectType.class), 
          true);
      return;
    }
    
    // Substitute the provided type arguments into the superclass type.
    ArrayRef<QualType> typeArgs = getTypeArgs();
    assert (typeArgs.size() == typeParams.size());
    CachedSuperClassType.setPointerAndInt(superClassType.substObjCTypeArgs(classDecl.getASTContext(), new ArrayRef(typeArgs), 
    ObjCSubstitutionContext.Superclass).$arrow().castAs(ObjCObjectType.class), 
        true);
  }

/*public:*/
  /// Gets the base type of this object type.  This is always (possibly
  /// sugar for) one of:
  ///  - the 'id' builtin type (as opposed to the 'id' type visible to the
  ///    user, which is a typedef for an ObjCObjectPointerType)
  ///  - the 'Class' builtin type (same caveat)
  ///  - an ObjCObjectType (currently always an ObjCInterfaceType)
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4782,
   FQN="clang::ObjCObjectType::getBaseType", NM="_ZNK5clang14ObjCObjectType11getBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType11getBaseTypeEv")
  //</editor-fold>
  public QualType getBaseType() /*const*/ {
    return new QualType(BaseType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isObjCId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4784,
   FQN="clang::ObjCObjectType::isObjCId", NM="_ZNK5clang14ObjCObjectType8isObjCIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType8isObjCIdEv")
  //</editor-fold>
  public boolean isObjCId() /*const*/ {
    return getBaseType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.ObjCId.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isObjCClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4787,
   FQN="clang::ObjCObjectType::isObjCClass", NM="_ZNK5clang14ObjCObjectType11isObjCClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType11isObjCClassEv")
  //</editor-fold>
  public boolean isObjCClass() /*const*/ {
    return getBaseType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.ObjCClass.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isObjCUnqualifiedId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4790,
   FQN="clang::ObjCObjectType::isObjCUnqualifiedId", NM="_ZNK5clang14ObjCObjectType19isObjCUnqualifiedIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType19isObjCUnqualifiedIdEv")
  //</editor-fold>
  public boolean isObjCUnqualifiedId() /*const*/ {
    return qual_empty() && isObjCId();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isObjCUnqualifiedClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4791,
   FQN="clang::ObjCObjectType::isObjCUnqualifiedClass", NM="_ZNK5clang14ObjCObjectType22isObjCUnqualifiedClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType22isObjCUnqualifiedClassEv")
  //</editor-fold>
  public boolean isObjCUnqualifiedClass() /*const*/ {
    return qual_empty() && isObjCClass();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isObjCUnqualifiedIdOrClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4792,
   FQN="clang::ObjCObjectType::isObjCUnqualifiedIdOrClass", NM="_ZNK5clang14ObjCObjectType26isObjCUnqualifiedIdOrClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType26isObjCUnqualifiedIdOrClassEv")
  //</editor-fold>
  public boolean isObjCUnqualifiedIdOrClass() /*const*/ {
    if (!qual_empty()) {
      return false;
    }
    {
      /*const*/ BuiltinType /*P*/ T = getBaseType().$arrow().getAs$BuiltinType();
      if ((T != null)) {
        return T.getKind() == BuiltinType.Kind.ObjCId
           || T.getKind() == BuiltinType.Kind.ObjCClass;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isObjCQualifiedId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4799,
   FQN="clang::ObjCObjectType::isObjCQualifiedId", NM="_ZNK5clang14ObjCObjectType17isObjCQualifiedIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType17isObjCQualifiedIdEv")
  //</editor-fold>
  public boolean isObjCQualifiedId() /*const*/ {
    return !qual_empty() && isObjCId();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isObjCQualifiedClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4800,
   FQN="clang::ObjCObjectType::isObjCQualifiedClass", NM="_ZNK5clang14ObjCObjectType20isObjCQualifiedClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType20isObjCQualifiedClassEv")
  //</editor-fold>
  public boolean isObjCQualifiedClass() /*const*/ {
    return !qual_empty() && isObjCClass();
  }

  
  /// Gets the interface declaration for this object type, if the base type
  /// really is an interface.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4970,
   FQN="clang::ObjCObjectType::getInterface", NM="_ZNK5clang14ObjCObjectType12getInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType12getInterfaceEv")
  //</editor-fold>
  public /*inline*/ ObjCInterfaceDecl /*P*/ getInterface() /*const*/ {
    QualType baseType = getBaseType();
    {
      /*const*/ ObjCObjectType /*P*/ ObjT;
      while (((/*P*/ ObjT = baseType.$arrow().getAs(ObjCObjectType.class)) != null)) {
        {
          /*const*/ ObjCInterfaceType /*P*/ T = dyn_cast_ObjCInterfaceType(ObjT);
          if ((T != null)) {
            return T.getDecl();
          }
        }
        
        baseType.$assignMove(ObjT.getBaseType());
      }
    }
    
    return null;
  }

  
  /// Determine whether this object type is "specialized", meaning
  /// that it has type arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isSpecialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 571,
   FQN="clang::ObjCObjectType::isSpecialized", NM="_ZNK5clang14ObjCObjectType13isSpecializedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType13isSpecializedEv")
  //</editor-fold>
  public boolean isSpecialized() /*const*/ {
    // If we have type arguments written here, the type is specialized.
    if (Unnamed_field.ObjCObjectTypeBits.NumTypeArgs > $int2uint_7bits(0)) {
      return true;
    }
    {
      
      // Otherwise, check whether the base type is specialized.
      /*const*/ ObjCObjectType /*P*/ objcObject = getBaseType().$arrow().getAs(ObjCObjectType.class);
      if ((objcObject != null)) {
        // Terminate when we reach an interface type.
        if (isa_ObjCInterfaceType(objcObject)) {
          return false;
        }
        
        return objcObject.isSpecialized();
      }
    }
    
    // Not specialized.
    return false;
  }

  
  /// Determine whether this object type was written with type arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isSpecializedAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4811,
   FQN="clang::ObjCObjectType::isSpecializedAsWritten", NM="_ZNK5clang14ObjCObjectType22isSpecializedAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType22isSpecializedAsWrittenEv")
  //</editor-fold>
  public boolean isSpecializedAsWritten() /*const*/ {
    return Unnamed_field.ObjCObjectTypeBits.NumTypeArgs > $int2uint_7bits(0);
  }

  
  /// Determine whether this object type is "unspecialized", meaning
  /// that it has no type arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isUnspecialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4817,
   FQN="clang::ObjCObjectType::isUnspecialized", NM="_ZNK5clang14ObjCObjectType15isUnspecializedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType15isUnspecializedEv")
  //</editor-fold>
  public boolean isUnspecialized() /*const*/ {
    return !isSpecialized();
  }

  
  /// Determine whether this object type is "unspecialized" as
  /// written, meaning that it has no type arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isUnspecializedAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4821,
   FQN="clang::ObjCObjectType::isUnspecializedAsWritten", NM="_ZNK5clang14ObjCObjectType24isUnspecializedAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType24isUnspecializedAsWrittenEv")
  //</editor-fold>
  public boolean isUnspecializedAsWritten() /*const*/ {
    return !isSpecializedAsWritten();
  }

  
  /// Retrieve the type arguments of this object type (semantically).
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getTypeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 589,
   FQN="clang::ObjCObjectType::getTypeArgs", NM="_ZNK5clang14ObjCObjectType11getTypeArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType11getTypeArgsEv")
  //</editor-fold>
  public ArrayRef<QualType> getTypeArgs() /*const*/ {
    // We have type arguments written on this type.
    if (isSpecializedAsWritten()) {
      return getTypeArgsAsWritten();
    }
    {
      
      // Look at the base type, which might have type arguments.
      /*const*/ ObjCObjectType /*P*/ objcObject = getBaseType().$arrow().getAs(ObjCObjectType.class);
      if ((objcObject != null)) {
        // Terminate when we reach an interface type.
        if (isa_ObjCInterfaceType(objcObject)) {
          return /*{ */new ArrayRef<QualType>(false)/* }*/;
        }
        
        return objcObject.getTypeArgs();
      }
    }
    
    // No type arguments.
    return /*{ */new ArrayRef<QualType>(false)/* }*/;
  }

  
  /// Retrieve the type arguments of this object type as they were
  /// written.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getTypeArgsAsWritten">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4828,
   FQN="clang::ObjCObjectType::getTypeArgsAsWritten", NM="_ZNK5clang14ObjCObjectType20getTypeArgsAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType20getTypeArgsAsWrittenEv")
  //</editor-fold>
  public ArrayRef<QualType> getTypeArgsAsWritten() /*const*/ {
    return llvm.makeArrayRef(getTypeArgStorage$Const(), 
        Unnamed_field.ObjCObjectTypeBits.NumTypeArgs, false/*storage contains objects, not pointers*/);
  }

  
  /*typedef ObjCProtocolDecl *const *qual_iterator*/
//  public final class qual_iterator extends type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/>{ };
  /*typedef llvm::iterator_range<qual_iterator> qual_range*/
//  public final class qual_range extends iterator_range<ObjCProtocolDecl /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::quals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4836,
   FQN="clang::ObjCObjectType::quals", NM="_ZNK5clang14ObjCObjectType5qualsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType5qualsEv")
  //</editor-fold>
  public iterator_range<ObjCProtocolDecl /*P*/ /*const*/> quals() /*const*/ {
    return new iterator_range<ObjCProtocolDecl /*P*/ /*const*/>(qual_begin(), qual_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::qual_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4837,
   FQN="clang::ObjCObjectType::qual_begin", NM="_ZNK5clang14ObjCObjectType10qual_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType10qual_beginEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> qual_begin() /*const*/ {
    return getProtocolStorage$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::qual_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4838,
   FQN="clang::ObjCObjectType::qual_end", NM="_ZNK5clang14ObjCObjectType8qual_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType8qual_endEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> qual_end() /*const*/ {
    return qual_begin().$add(getNumProtocols());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::qual_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4840,
   FQN="clang::ObjCObjectType::qual_empty", NM="_ZNK5clang14ObjCObjectType10qual_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType10qual_emptyEv")
  //</editor-fold>
  public boolean qual_empty() /*const*/ {
    return getNumProtocols() == 0;
  }

  
  /// Return the number of qualifying protocols in this interface type,
  /// or 0 if there are none.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getNumProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4844,
   FQN="clang::ObjCObjectType::getNumProtocols", NM="_ZNK5clang14ObjCObjectType15getNumProtocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType15getNumProtocolsEv")
  //</editor-fold>
  public /*uint*/int getNumProtocols() /*const*/ {
    return Unnamed_field.ObjCObjectTypeBits.NumProtocols;
  }

  
  /// Fetch a protocol by index.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4847,
   FQN="clang::ObjCObjectType::getProtocol", NM="_ZNK5clang14ObjCObjectType11getProtocolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType11getProtocolEj")
  //</editor-fold>
  public ObjCProtocolDecl /*P*/ getProtocol(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, getNumProtocols())) : "Out-of-range protocol access";
    return qual_begin().$at(I);
  }

  
  /// Retrieve all of the protocol qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4853,
   FQN="clang::ObjCObjectType::getProtocols", NM="_ZNK5clang14ObjCObjectType12getProtocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType12getProtocolsEv")
  //</editor-fold>
  public ArrayRef<ObjCProtocolDecl /*P*/ > getProtocols() /*const*/ {
    return new ArrayRef<ObjCProtocolDecl /*P*/ >(qual_begin(), getNumProtocols(), true);
  }

  
  /// Whether this is a "__kindof" type as written.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isKindOfTypeAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4858,
   FQN="clang::ObjCObjectType::isKindOfTypeAsWritten", NM="_ZNK5clang14ObjCObjectType21isKindOfTypeAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType21isKindOfTypeAsWrittenEv")
  //</editor-fold>
  public boolean isKindOfTypeAsWritten() /*const*/ {
    return Unnamed_field.ObjCObjectTypeBits.IsKindOf;
  }

  
  /// Whether this ia a "__kindof" type (semantically).
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isKindOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 607,
   FQN="clang::ObjCObjectType::isKindOfType", NM="_ZNK5clang14ObjCObjectType12isKindOfTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType12isKindOfTypeEv")
  //</editor-fold>
  public boolean isKindOfType() /*const*/ {
    if (isKindOfTypeAsWritten()) {
      return true;
    }
    {
      
      // Look at the base type, which might have type arguments.
      /*const*/ ObjCObjectType /*P*/ objcObject = getBaseType().$arrow().getAs(ObjCObjectType.class);
      if ((objcObject != null)) {
        // Terminate when we reach an interface type.
        if (isa_ObjCInterfaceType(objcObject)) {
          return false;
        }
        
        return objcObject.isKindOfType();
      }
    }
    
    // Not a "__kindof" type.
    return false;
  }

  
  /// Retrieve the type of the superclass of this object type.
  ///
  /// This operation substitutes any type arguments into the
  /// superclass of the current class type, potentially producing a
  /// specialization of the superclass type. Produces a null type if
  /// there is no superclass.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::getSuperClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4869,
   FQN="clang::ObjCObjectType::getSuperClassType", NM="_ZNK5clang14ObjCObjectType17getSuperClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType17getSuperClassTypeEv")
  //</editor-fold>
  public QualType getSuperClassType() /*const*/ {
    if (!CachedSuperClassType.getInt()) {
      computeSuperClassTypeSlow();
    }
    assert (CachedSuperClassType.getInt()) : "Superclass not set?";
    return new QualType(CachedSuperClassType.getPointer(), 0);
  }

  
  /// Strip off the Objective-C "kindof" type and (with it) any
  /// protocol qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::stripObjCKindOfTypeAndQuals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 624,
   FQN="clang::ObjCObjectType::stripObjCKindOfTypeAndQuals", NM="_ZNK5clang14ObjCObjectType27stripObjCKindOfTypeAndQualsERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType27stripObjCKindOfTypeAndQualsERKNS_10ASTContextE")
  //</editor-fold>
  public QualType stripObjCKindOfTypeAndQuals(final /*const*/ ASTContext /*&*/ ctx) /*const*/ {
    if (!isKindOfType() && qual_empty()) {
      return new QualType(this, 0);
    }
    
    // Recursively strip __kindof.
    SplitQualType splitBaseType = getBaseType().split();
    QualType baseType/*J*/= new QualType(splitBaseType.Ty, 0);
    {
      /*const*/ ObjCObjectType /*P*/ baseObj = splitBaseType.Ty.getAs(ObjCObjectType.class);
      if ((baseObj != null)) {
        baseType.$assignMove(baseObj.stripObjCKindOfTypeAndQuals(ctx));
      }
    }
    
    return ctx.getObjCObjectType(ctx.getQualifiedType(new QualType(baseType), 
            new Qualifiers(splitBaseType.Quals)), 
        getTypeArgsAsWritten(), 
        /*protocols=*/ /*{ */new ArrayRef<ObjCProtocolDecl /*P*/ >(true)/* }*/, 
        /*isKindOf=*/ false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4881,
   FQN="clang::ObjCObjectType::isSugared", NM="_ZNK5clang14ObjCObjectType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4882,
   FQN="clang::ObjCObjectType::desugar", NM="_ZNK5clang14ObjCObjectType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ObjCObjectType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4884,
   FQN="clang::ObjCObjectType::classof", NM="_ZN5clang14ObjCObjectType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ObjCObjectType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.ObjCObject
       || T.getTypeClass() == TypeClass.ObjCInterface;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final type$ptr<QualType /*P*/> $TypeArgs;

  private final type$ptr<ObjCProtocolDecl /*P*/ /*P*/> $Protocols;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BaseType=" + BaseType // NOI18N
              + ", CachedSuperClassType=" + CachedSuperClassType // NOI18N
              + super.toString(); // NOI18N
  }
}
