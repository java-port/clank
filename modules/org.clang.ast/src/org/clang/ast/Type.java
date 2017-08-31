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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.impl.TypeStatics.*;


/// The base class of the type hierarchy.
///
/// A central concept with types is that each type always has a canonical
/// type.  A canonical type is the type with any typedef names stripped out
/// of it or the types it references.  For example, consider:
///
///  typedef int  foo;
///  typedef foo* bar;
///    'int *'    'foo *'    'bar'
///
/// There will be a Type object created for 'int'.  Since int is canonical, its
/// CanonicalType pointer points to itself.  There is also a Type for 'foo' (a
/// TypedefType).  Its CanonicalType pointer points to the 'int' Type.  Next
/// there is a PointerType that represents 'int*', which, like 'int', is
/// canonical.  Finally, there is a PointerType type for 'foo*' whose canonical
/// type is 'int*', and there is a TypedefType for 'bar', whose canonical type
/// is also 'int*'.
///
/// Non-canonical types are useful for emitting diagnostics, without losing
/// information about typedefs being used.  Canonical types are useful for type
/// comparisons (they allow by-pointer equality tests) and useful for reasoning
/// about whether something has a particular form (e.g. is a function type),
/// because they implicitly, recursively, strip all typedefs out of a type.
///
/// Types, once created, are immutable.
///
//<editor-fold defaultstate="collapsed" desc="clang::Type">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1281,
 FQN="clang::Type", NM="_ZN5clang4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4TypeE")
//</editor-fold>
public class Type extends /*public*/ ExtQualsTypeCommonBase {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Type::TypeClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1283,
   FQN="clang::Type::TypeClass", NM="_ZN5clang4Type9TypeClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type9TypeClassE")
  //</editor-fold>
  public enum TypeClass implements Native.ComparableLower {
    Builtin(0),
    Complex(Builtin.getValue() + 1),
    Pointer(Complex.getValue() + 1),
    BlockPointer(Pointer.getValue() + 1),
    LValueReference(BlockPointer.getValue() + 1),
    RValueReference(LValueReference.getValue() + 1),
    MemberPointer(RValueReference.getValue() + 1),
    ConstantArray(MemberPointer.getValue() + 1),
    IncompleteArray(ConstantArray.getValue() + 1),
    VariableArray(IncompleteArray.getValue() + 1),
    DependentSizedArray(VariableArray.getValue() + 1),
    DependentSizedExtVector(DependentSizedArray.getValue() + 1),
    Vector(DependentSizedExtVector.getValue() + 1),
    ExtVector(Vector.getValue() + 1),
    FunctionProto(ExtVector.getValue() + 1),
    FunctionNoProto(FunctionProto.getValue() + 1),
    UnresolvedUsing(FunctionNoProto.getValue() + 1),
    Paren(UnresolvedUsing.getValue() + 1),
    Typedef(Paren.getValue() + 1),
    Adjusted(Typedef.getValue() + 1),
    Decayed(Adjusted.getValue() + 1),
    TypeOfExpr(Decayed.getValue() + 1),
    TypeOf(TypeOfExpr.getValue() + 1),
    Decltype(TypeOf.getValue() + 1),
    UnaryTransform(Decltype.getValue() + 1),
    Record(UnaryTransform.getValue() + 1),
    Enum(Record.getValue() + 1),
    Elaborated(Enum.getValue() + 1),
    Attributed(Elaborated.getValue() + 1),
    TemplateTypeParm(Attributed.getValue() + 1),
    SubstTemplateTypeParm(TemplateTypeParm.getValue() + 1),
    SubstTemplateTypeParmPack(SubstTemplateTypeParm.getValue() + 1),
    TemplateSpecialization(SubstTemplateTypeParmPack.getValue() + 1),
    Auto(TemplateSpecialization.getValue() + 1),
    InjectedClassName(Auto.getValue() + 1),
    DependentName(InjectedClassName.getValue() + 1),
    DependentTemplateSpecialization(DependentName.getValue() + 1),
    PackExpansion(DependentTemplateSpecialization.getValue() + 1),
    ObjCObject(PackExpansion.getValue() + 1),
    ObjCInterface(ObjCObject.getValue() + 1),
    ObjCObjectPointer(ObjCInterface.getValue() + 1),
    Pipe(ObjCObjectPointer.getValue() + 1),
    Atomic(Pipe.getValue() + 1),
    TypeLast(TypeClass.Atomic.getValue()),
    TagFirst(TypeClass.Record.getValue()),
    TagLast(TypeClass.Enum.getValue()),
    // JAVA: added this value, because LocInfoType uses it in TypeClass.valueOf
    LocInfoType$Java(TypeLast.getValue() + 1);
    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TypeClass valueOf(int val) {
      TypeClass out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TypeClass[] VALUES;
      private static final TypeClass[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TypeClass kind : TypeClass.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TypeClass[min < 0 ? (1-min) : 0];
        VALUES = new TypeClass[max >= 0 ? (1+max) : 0];
        for (TypeClass kind : TypeClass.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private TypeClass(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TypeClass)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TypeClass)obj).value);}
    //</editor-fold>
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Type::Type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1292,
   FQN="clang::Type::Type", NM="_ZN5clang4TypeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4TypeC1ERKS0_")
  //</editor-fold>
  private Type(final /*const*/ Type /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::Type::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1293,
   FQN="clang::Type::operator=", NM="_ZN5clang4TypeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4TypeaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ Type /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /// Bitfields required by the Type class.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::TypeBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1296,
   FQN="clang::Type::TypeBitfields", NM="_ZN5clang4Type13TypeBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type13TypeBitfieldsE")
  //</editor-fold>
  /*friend*/public/*private*/ static class TypeBitfields {
    /*friend  class Type*/
    /*friend template <class T> class TypePropertyCache*/
    
    /// TypeClass bitfield - Enum that specifies what subclass this belongs to.
    private /*JBYTE unsigned int*/ byte TC /*: 8*/;
    
    /// Whether this type is a dependent type (C++ [temp.dep.type]).
    private /*JBIT unsigned int*/ boolean Dependent /*: 1*/;
    
    /// Whether this type somehow involves a template parameter, even
    /// if the resolution of the type does not depend on a template parameter.
    private /*JBIT unsigned int*/ boolean InstantiationDependent /*: 1*/;
    
    /// Whether this type is a variably-modified type (C99 6.7.5).
    private /*JBIT unsigned int*/ boolean VariablyModified /*: 1*/;
    
    /// \brief Whether this type contains an unexpanded parameter pack
    /// (for C++11 variadic templates).
    private /*JBIT unsigned int*/ boolean ContainsUnexpandedParameterPack /*: 1*/;
    
    /// \brief True if the cache (i.e. the bitfields here starting with
    /// 'Cache') is valid.
    /*friend*/public/*private*/ /*mutable *//*JBIT unsigned int*/ boolean CacheValid /*: 1*/;
    
    /// \brief Linkage of this type.
    /*friend*/public/*private*/ /*mutable *//*JBYTE unsigned int*/ byte CachedLinkage /*: 3*/;
    
    /// \brief Whether this type involves and local or unnamed types.
    /*friend*/public/*private*/ /*mutable *//*JBIT unsigned int*/ boolean CachedLocalOrUnnamed /*: 1*/;
    
    /// \brief Whether this type comes from an AST file.
    /*friend*/public/*private*/ /*mutable *//*JBIT unsigned int*/ boolean FromAST /*: 1*/;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Type::TypeBitfields::isCacheValid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1330,
     FQN="clang::Type::TypeBitfields::isCacheValid", NM="_ZNK5clang4Type13TypeBitfields12isCacheValidEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type13TypeBitfields12isCacheValidEv")
    //</editor-fold>
    /*friend*/public/*private*/ boolean isCacheValid() /*const*/ {
      return CacheValid;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Type::TypeBitfields::getLinkage">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1333,
     FQN="clang::Type::TypeBitfields::getLinkage", NM="_ZNK5clang4Type13TypeBitfields10getLinkageEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type13TypeBitfields10getLinkageEv")
    //</editor-fold>
    /*friend*/public/*private*/ Linkage getLinkage() /*const*/ {
      assert (isCacheValid()) : "getting linkage from invalid cache";
      return /*static_cast*/Linkage.valueOf(CachedLinkage);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Type::TypeBitfields::hasLocalOrUnnamedType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1337,
     FQN="clang::Type::TypeBitfields::hasLocalOrUnnamedType", NM="_ZNK5clang4Type13TypeBitfields21hasLocalOrUnnamedTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type13TypeBitfields21hasLocalOrUnnamedTypeEv")
    //</editor-fold>
    /*friend*/public/*private*/ boolean hasLocalOrUnnamedType() /*const*/ {
      assert (isCacheValid()) : "getting linkage from invalid cache";
      return CachedLocalOrUnnamed;
    }

    
    @Override public String toString() {
      return "" + "TC=" + $uchar2uint(TC) // NOI18N
                + ", Dependent=" + Dependent // NOI18N
                + ", InstantiationDependent=" + InstantiationDependent // NOI18N
                + ", VariablyModified=" + VariablyModified // NOI18N
                + ", ContainsUnexpandedParameterPack=" + ContainsUnexpandedParameterPack // NOI18N
                + ", CacheValid=" + CacheValid // NOI18N
                + ", CachedLinkage=" + $uchar2uint(CachedLinkage) // NOI18N
                + ", CachedLocalOrUnnamed=" + CachedLocalOrUnnamed // NOI18N
                + ", FromAST=" + FromAST; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::Type::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1342,
   FQN="clang::Type::(anonymous)", NM="_ZN5clang4TypeE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4TypeE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumTypeBits = 18;
  /*}*/;
/*protected:*/
  // These classes allow subclasses to somewhat cleanly pack bitfields
  // into Type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::ArrayTypeBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1348,
   FQN="clang::Type::ArrayTypeBitfields", NM="_ZN5clang4Type18ArrayTypeBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type18ArrayTypeBitfieldsE")
  //</editor-fold>
  protected static class ArrayTypeBitfields {
    /*friend  class ArrayType*/
    
    private /*uint*/int Unnamed_field /*: NumTypeBits*/;
    
    /// CVR qualifiers from declarations like
    /// 'int X[static restrict 4]'. For function parameters only.
    /*friend*/public/*private*/ /*JBYTE unsigned int*/ byte IndexTypeQuals /*: 3*/;
    
    /// Storage class qualifiers from declarations like
    /// 'int X[static restrict 4]'. For function parameters only.
    /// Actually an ArrayType::ArraySizeModifier.
    /*friend*/public/*private*/ /*JBYTE unsigned int*/ byte SizeModifier /*: 3*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + ", IndexTypeQuals=" + $uchar2uint(IndexTypeQuals) // NOI18N
                + ", SizeModifier=" + $uchar2uint(SizeModifier); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::BuiltinTypeBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1363,
   FQN="clang::Type::BuiltinTypeBitfields", NM="_ZN5clang4Type20BuiltinTypeBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type20BuiltinTypeBitfieldsE")
  //</editor-fold>
  protected static class BuiltinTypeBitfields {
    /*friend  class BuiltinType*/
    
    private /*uint*/int Unnamed_field /*: NumTypeBits*/;
    
    /// The kind (BuiltinType::Kind) of builtin type this is.
    /*friend*//*private*/ /*JBYTE unsigned int*/ byte Kind /*: 8*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + ", Kind=" + $uchar2uint(Kind); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::FunctionTypeBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1372,
   FQN="clang::Type::FunctionTypeBitfields", NM="_ZN5clang4Type21FunctionTypeBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type21FunctionTypeBitfieldsE")
  //</editor-fold>
  protected static class FunctionTypeBitfields {
    /*friend  class FunctionType*/
    /*friend  class FunctionProtoType*/
    
    private /*uint*/int Unnamed_field /*: NumTypeBits*/;
    
    /// Extra information which affects how the function is called, like
    /// regparm and the calling convention.
    /*friend*/protected/*private*/ /*JCHAR unsigned int*/ char ExtInfo /*: 9*/;

    /// Used only by FunctionProtoType, put here to pack with the
    /// other bitfields.
    /// The qualifiers are part of FunctionProtoType because...
    ///
    /// C++ 8.3.5p4: The return type, the parameter type list and the
    /// cv-qualifier-seq, [...], are part of the function type.
    /*friend*/protected/*private*/ /*JBYTE unsigned int*/ byte TypeQuals /*: 4*/;

    /// \brief The ref-qualifier associated with a \c FunctionProtoType.
    ///
    /// This is a value of type \c RefQualifierKind.
    /*friend*/protected/*private*/ /*JBYTE unsigned int*/ byte RefQualifier /*: 2*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + ", ExtInfo=" + $ushort2uint(ExtInfo) // NOI18N
                + ", TypeQuals=" + $uchar2uint(TypeQuals) // NOI18N
                + ", RefQualifier=" + $uchar2uint(RefQualifier); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::ObjCObjectTypeBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1396,
   FQN="clang::Type::ObjCObjectTypeBitfields", NM="_ZN5clang4Type23ObjCObjectTypeBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type23ObjCObjectTypeBitfieldsE")
  //</editor-fold>
  protected static class ObjCObjectTypeBitfields {
    /*friend  class ObjCObjectType*/
    
    private /*uint*/int Unnamed_field /*: NumTypeBits*/;
    
    /// The number of type arguments stored directly on this object type.
    /*friend*/protected/*private*/ /*JBYTE unsigned int*/ byte NumTypeArgs /*: 7*/;
  
    /// The number of protocols stored directly on this object type.
    /*friend*/protected/*private*/ /*JBYTE unsigned int*/ byte NumProtocols /*: 6*/;
  
    /// Whether this is a "kindof" type.
    /*friend*/protected/*private*/ /*JBIT unsigned int*/ boolean IsKindOf /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + ", NumTypeArgs=" + $uchar2uint(NumTypeArgs) // NOI18N
                + ", NumProtocols=" + $uchar2uint(NumProtocols) // NOI18N
                + ", IsKindOf=" + IsKindOf; // NOI18N
    }
  };
  static { static_assert(NumTypeBits + 7 + 6 + 1 <= 32, $("Does not fit in an unsigned")); };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::ReferenceTypeBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1412,
   FQN="clang::Type::ReferenceTypeBitfields", NM="_ZN5clang4Type22ReferenceTypeBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type22ReferenceTypeBitfieldsE")
  //</editor-fold>
  protected static class ReferenceTypeBitfields {
    /*friend  class ReferenceType*/
    
    private /*uint*/int Unnamed_field /*: NumTypeBits*/;
    
    /// True if the type was originally spelled with an lvalue sigil.
    /// This is never true of rvalue references but can also be false
    /// on lvalue references because of C++0x [dcl.typedef]p9,
    /// as follows:
    ///
    ///   typedef int &ref;    // lvalue, spelled lvalue
    ///   typedef int &&rvref; // rvalue
    ///   ref &a;              // lvalue, inner ref, spelled lvalue
    ///   ref &&a;             // lvalue, inner ref
    ///   rvref &a;            // lvalue, inner ref, spelled lvalue
    ///   rvref &&a;           // rvalue, inner ref
    /*friend*/protected/*private*/ /*JBIT unsigned int*/ boolean SpelledAsLValue /*: 1*/;
  
    /// True if the inner type is a reference type.  This only happens
    /// in non-canonical forms.
    /*friend*/protected/*private*/ /*JBIT unsigned int*/ boolean InnerRef /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + ", SpelledAsLValue=" + SpelledAsLValue // NOI18N
                + ", InnerRef=" + InnerRef; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::TypeWithKeywordBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1435,
   FQN="clang::Type::TypeWithKeywordBitfields", NM="_ZN5clang4Type24TypeWithKeywordBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type24TypeWithKeywordBitfieldsE")
  //</editor-fold>
  protected static class TypeWithKeywordBitfields {
    /*friend  class TypeWithKeyword*/
    
    private /*uint*/int Unnamed_field /*: NumTypeBits*/;
    
    /// An ElaboratedTypeKeyword.  8 bits for efficient access.
    /*friend*/protected/*private*/ /*JBYTE unsigned int*/ byte Keyword /*: 8*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + ", Keyword=" + $uchar2uint(Keyword); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::VectorTypeBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1444,
   FQN="clang::Type::VectorTypeBitfields", NM="_ZN5clang4Type19VectorTypeBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type19VectorTypeBitfieldsE")
  //</editor-fold>
  protected static class VectorTypeBitfields {
    /*friend  class VectorType*/
    
    private /*uint*/int Unnamed_field /*: NumTypeBits*/;
    
    /// The kind of vector, either a generic vector type or some
    /// target-specific vector type such as for AltiVec or Neon.
    /*friend*/protected/*private*/ /*JBYTE unsigned int*/ byte VecKind /*: 3*/;
    
    /// The number of elements in the vector.
    /*friend*/protected/*private*/ /*JCHAR unsigned int*/ char NumElements /*: 29 - NumTypeBits*/;
    //<editor-fold defaultstate="collapsed" desc="clang::Type::VectorTypeBitfields::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1456,
     FQN="clang::Type::VectorTypeBitfields::(anonymous)", NM="_ZN5clang4Type19VectorTypeBitfieldsE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type19VectorTypeBitfieldsE_Unnamed_enum")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      public static final /*uint*/int MaxNumElements = (1 << (29 - NumTypeBits)) - 1;
    /*}*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + ", VecKind=" + $uchar2uint(VecKind) // NOI18N
                + ", NumElements=" + $ushort2uint(NumElements); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::AttributedTypeBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1459,
   FQN="clang::Type::AttributedTypeBitfields", NM="_ZN5clang4Type23AttributedTypeBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type23AttributedTypeBitfieldsE")
  //</editor-fold>
  protected static class AttributedTypeBitfields {
    /*friend  class AttributedType*/
    
    private /*uint*/int Unnamed_field /*: NumTypeBits*/;
    
    /// An AttributedType::Kind
    /*friend*/public/*private*/ /*JCHAR unsigned int*/ char AttrKind /*: 32 - NumTypeBits*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + ", AttrKind=" + $ushort2uint(AttrKind); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::AutoTypeBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1468,
   FQN="clang::Type::AutoTypeBitfields", NM="_ZN5clang4Type17AutoTypeBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type17AutoTypeBitfieldsE")
  //</editor-fold>
  protected static class AutoTypeBitfields {
    /*friend  class AutoType*/
    
    private /*uint*/int Unnamed_field /*: NumTypeBits*/;
    
    /// Was this placeholder type spelled as 'auto', 'decltype(auto)',
    /// or '__auto_type'?  AutoTypeKeyword value.
    /*friend*/public/*private*/ /*JBYTE unsigned int*/ byte Keyword /*: 2*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + ", Keyword=" + $uchar2uint(Keyword); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::Type::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*public access*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1478,
   FQN="clang::Type::(anonymous)", NM="_ZN5clang4TypeE_Unnamed_union11",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4TypeE_Unnamed_union11")
  //</editor-fold>
  /*friend*/public/*protected*/ static class/*union*/ Unnamed_union11 {
    public TypeBitfields TypeBits;
    public ArrayTypeBitfields ArrayTypeBits;
    public AttributedTypeBitfields AttributedTypeBits;
    public AutoTypeBitfields AutoTypeBits;
    public BuiltinTypeBitfields BuiltinTypeBits;
    public FunctionTypeBitfields FunctionTypeBits;
    public ObjCObjectTypeBitfields ObjCObjectTypeBits;
    public ReferenceTypeBitfields ReferenceTypeBits;
    public TypeWithKeywordBitfields TypeWithKeywordBits;
    public VectorTypeBitfields VectorTypeBits;
    
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added ctr*/)
    public Unnamed_union11() {
      this.TypeBits = new TypeBitfields();
      this.ArrayTypeBits = new ArrayTypeBitfields();
      this.AttributedTypeBits = new AttributedTypeBitfields();
      this.AutoTypeBits = new AutoTypeBitfields();
      this.BuiltinTypeBits = new BuiltinTypeBitfields();
      this.FunctionTypeBits = new FunctionTypeBitfields();
      this.ObjCObjectTypeBits = new ObjCObjectTypeBitfields();
      this.ReferenceTypeBits = new ReferenceTypeBitfields();
      this.TypeWithKeywordBits = new TypeWithKeywordBitfields();
      this.VectorTypeBits = new VectorTypeBitfields();
    }
    
    @Override public String toString() {
      return "" + "TypeBits=" + TypeBits // NOI18N
                + ", ArrayTypeBits=" + ArrayTypeBits // NOI18N
                + ", AttributedTypeBits=" + AttributedTypeBits // NOI18N
                + ", AutoTypeBits=" + AutoTypeBits // NOI18N
                + ", BuiltinTypeBits=" + BuiltinTypeBits // NOI18N
                + ", FunctionTypeBits=" + FunctionTypeBits // NOI18N
                + ", ObjCObjectTypeBits=" + ObjCObjectTypeBits // NOI18N
                + ", ReferenceTypeBits=" + ReferenceTypeBits // NOI18N
                + ", TypeWithKeywordBits=" + TypeWithKeywordBits // NOI18N
                + ", VectorTypeBits=" + VectorTypeBits; // NOI18N
    }
  };
  // JAVA: initialize field
  /*friend*/public/*protected*/ Unnamed_union11 Unnamed_field = new Unnamed_union11();
/*private:*/
  /// \brief Set whether this type comes from an AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::setFromAST">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1493,
   FQN="clang::Type::setFromAST", NM="_ZNK5clang4Type10setFromASTEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type10setFromASTEb")
  //</editor-fold>
  /*friend*/public void setFromAST() /*const*/ {
    setFromAST(true);
  }
  private void setFromAST(boolean V/*= true*/) /*const*/ {
    Unnamed_field.TypeBits.FromAST = V;
  }

  
  /*friend template <class T> class TypePropertyCache*/
/*protected:*/
  // silence VC++ warning C4355: 'this' : used in base member initializer list
  //<editor-fold defaultstate="collapsed" desc="clang::Type::this_">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1501,
   FQN="clang::Type::this_", NM="_ZN5clang4Type5this_Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type5this_Ev")
  //</editor-fold>
  protected Type /*P*/ this_() {
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::Type">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*introduced $Type(args)*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1502,
   FQN="clang::Type::Type", NM="_ZN5clang4TypeC1ENS0_9TypeClassENS_8QualTypeEbbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4TypeC1ENS0_9TypeClassENS_8QualTypeEbbbb")
  //</editor-fold>
  protected void $Type(TypeClass tc, QualType canon, boolean Dependent, 
      boolean InstantiationDependent, boolean VariablyModified, 
      boolean ContainsUnexpandedParameterPack) {
    // : ExtQualsTypeCommonBase(this, canon.isNull() ? QualType(this_(), 0) : canon) 
    //START JInit
    $ExtQualsTypeCommonBase(this, 
        canon.isNull() ? new QualType(this_(), 0) : new QualType(canon));
    //END JInit
    Unnamed_field.TypeBits.TC = $uint2uint_8bits(tc.getValue());
    Unnamed_field.TypeBits.Dependent = Dependent;
    Unnamed_field.TypeBits.InstantiationDependent = Dependent || InstantiationDependent;
    Unnamed_field.TypeBits.VariablyModified = VariablyModified;
    Unnamed_field.TypeBits.ContainsUnexpandedParameterPack = ContainsUnexpandedParameterPack;
    Unnamed_field.TypeBits.CacheValid = false;
    Unnamed_field.TypeBits.CachedLocalOrUnnamed = false;
    Unnamed_field.TypeBits.CachedLinkage = $uint2uint_3bits(Linkage.NoLinkage.getValue());
    Unnamed_field.TypeBits.FromAST = false;
  }

  /*friend  class ASTContext*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::setDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1519,
   FQN="clang::Type::setDependent", NM="_ZN5clang4Type12setDependentEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type12setDependentEb")
  //</editor-fold>
  /*friend*/public/*protected*/ void setDependent() {
    setDependent(true);
  }
  /*friend*/public/*protected*/ void setDependent(boolean D/*= true*/) {
    Unnamed_field.TypeBits.Dependent = D;
    if (D) {
      Unnamed_field.TypeBits.InstantiationDependent = true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::setInstantiationDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1524,
   FQN="clang::Type::setInstantiationDependent", NM="_ZN5clang4Type25setInstantiationDependentEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type25setInstantiationDependentEb")
  //</editor-fold>
  protected void setInstantiationDependent() {
    setInstantiationDependent(true);
  }
  protected void setInstantiationDependent(boolean D/*= true*/) {
    Unnamed_field.TypeBits.InstantiationDependent = D;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::setVariablyModified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1526,
   FQN="clang::Type::setVariablyModified", NM="_ZN5clang4Type19setVariablyModifiedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type19setVariablyModifiedEb")
  //</editor-fold>
  protected void setVariablyModified() {
    setVariablyModified(true);
  }
  protected void setVariablyModified(boolean VM/*= true*/) {
    Unnamed_field.TypeBits.VariablyModified = VM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::setContainsUnexpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1528,
   FQN="clang::Type::setContainsUnexpandedParameterPack", NM="_ZN5clang4Type34setContainsUnexpandedParameterPackEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type34setContainsUnexpandedParameterPackEb")
  //</editor-fold>
  protected void setContainsUnexpandedParameterPack() {
    setContainsUnexpandedParameterPack(true);
  }
  protected void setContainsUnexpandedParameterPack(boolean PP/*= true*/) {
    Unnamed_field.TypeBits.ContainsUnexpandedParameterPack = PP;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getTypeClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1533,
   FQN="clang::Type::getTypeClass", NM="_ZNK5clang4Type12getTypeClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type12getTypeClassEv")
  //</editor-fold>
  public TypeClass getTypeClass() /*const*/ {
    return /*static_cast*/TypeClass.valueOf($8bits_uint2uint(Unnamed_field.TypeBits.TC));
  }

  
  /// \brief Whether this type comes from an AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isFromAST">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1536,
   FQN="clang::Type::isFromAST", NM="_ZNK5clang4Type9isFromASTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type9isFromASTEv")
  //</editor-fold>
  public boolean isFromAST() /*const*/ {
    return Unnamed_field.TypeBits.FromAST;
  }

  
  /// \brief Whether this type is or contains an unexpanded parameter
  /// pack, used to support C++0x variadic templates.
  ///
  /// A type that contains a parameter pack shall be expanded by the
  /// ellipsis operator at some point. For example, the typedef in the
  /// following example contains an unexpanded parameter pack 'T':
  ///
  /// \code
  /// template<typename ...T>
  /// struct X {
  ///   typedef T* pointer_types; // ill-formed; T is a parameter pack.
  /// };
  /// \endcode
  ///
  /// Note that this routine does not specify which
  //<editor-fold defaultstate="collapsed" desc="clang::Type::containsUnexpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1553,
   FQN="clang::Type::containsUnexpandedParameterPack", NM="_ZNK5clang4Type31containsUnexpandedParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type31containsUnexpandedParameterPackEv")
  //</editor-fold>
  public boolean containsUnexpandedParameterPack() /*const*/ {
    return Unnamed_field.TypeBits.ContainsUnexpandedParameterPack;
  }

  
  /// Determines if this type would be canonical if it had no further
  /// qualification.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isCanonicalUnqualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1559,
   FQN="clang::Type::isCanonicalUnqualified", NM="_ZNK5clang4Type22isCanonicalUnqualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type22isCanonicalUnqualifiedEv")
  //</editor-fold>
  public boolean isCanonicalUnqualified() /*const*/ {
    return $eq_QualType$C(CanonicalType, new QualType(this, 0));
  }

  
  /// Pull a single level of sugar off of this locally-unqualified type.
  /// Users should generally prefer SplitQualType::getSingleStepDesugaredType()
  /// or QualType::getSingleStepDesugaredType(const ASTContext&).
  
  /// Pull a single level of sugar off of this locally-unqualified type.
  /// Users should generally prefer SplitQualType::getSingleStepDesugaredType()
  /// or QualType::getSingleStepDesugaredType(const ASTContext&).
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getLocallyUnqualifiedSingleStepDesugaredType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 224,
   FQN="clang::Type::getLocallyUnqualifiedSingleStepDesugaredType", NM="_ZNK5clang4Type44getLocallyUnqualifiedSingleStepDesugaredTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type44getLocallyUnqualifiedSingleStepDesugaredTypeEv")
  //</editor-fold>
  public QualType getLocallyUnqualifiedSingleStepDesugaredType() /*const*/ {
    switch (getTypeClass()) {
     case Builtin:
      {
        /*const*/ BuiltinType /*P*/ ty = cast_BuiltinType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Complex:
      {
        /*const*/ ComplexType /*P*/ ty = cast_ComplexType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Pointer:
      {
        /*const*/ PointerType /*P*/ ty = cast_PointerType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case BlockPointer:
      {
        /*const*/ BlockPointerType /*P*/ ty = cast_BlockPointerType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case LValueReference:
      {
        /*const*/ LValueReferenceType /*P*/ ty = cast_LValueReferenceType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case RValueReference:
      {
        /*const*/ RValueReferenceType /*P*/ ty = cast_RValueReferenceType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case MemberPointer:
      {
        /*const*/ MemberPointerType /*P*/ ty = cast_MemberPointerType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case ConstantArray:
      {
        /*const*/ ConstantArrayType /*P*/ ty = cast_ConstantArrayType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case IncompleteArray:
      {
        /*const*/ IncompleteArrayType /*P*/ ty = cast_IncompleteArrayType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case VariableArray:
      {
        /*const*/ VariableArrayType /*P*/ ty = cast_VariableArrayType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case DependentSizedArray:
      {
        /*const*/ DependentSizedArrayType /*P*/ ty = cast_DependentSizedArrayType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case DependentSizedExtVector:
      {
        /*const*/ DependentSizedExtVectorType /*P*/ ty = cast_DependentSizedExtVectorType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Vector:
      {
        /*const*/ VectorType /*P*/ ty = cast_VectorType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case ExtVector:
      {
        /*const*/ ExtVectorType /*P*/ ty = cast_ExtVectorType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case FunctionProto:
      {
        /*const*/ FunctionProtoType /*P*/ ty = cast_FunctionProtoType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case FunctionNoProto:
      {
        /*const*/ FunctionNoProtoType /*P*/ ty = cast_FunctionNoProtoType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case UnresolvedUsing:
      {
        /*const*/ UnresolvedUsingType /*P*/ ty = cast_UnresolvedUsingType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Paren:
      {
        /*const*/ ParenType /*P*/ ty = cast_ParenType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Typedef:
      {
        /*const*/ TypedefType /*P*/ ty = cast_TypedefType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Adjusted:
      {
        /*const*/ AdjustedType /*P*/ ty = cast_AdjustedType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Decayed:
      {
        /*const*/ DecayedType /*P*/ ty = cast_DecayedType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case TypeOfExpr:
      {
        /*const*/ TypeOfExprType /*P*/ ty = cast_TypeOfExprType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case TypeOf:
      {
        /*const*/ TypeOfType /*P*/ ty = cast_TypeOfType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Decltype:
      {
        /*const*/ DecltypeType /*P*/ ty = cast_DecltypeType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case UnaryTransform:
      {
        /*const*/ UnaryTransformType /*P*/ ty = cast_UnaryTransformType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Record:
      {
        /*const*/ RecordType /*P*/ ty = cast_RecordType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Enum:
      {
        /*const*/ EnumType /*P*/ ty = cast_EnumType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Elaborated:
      {
        /*const*/ ElaboratedType /*P*/ ty = cast_ElaboratedType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Attributed:
      {
        /*const*/ AttributedType /*P*/ ty = cast_AttributedType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case TemplateTypeParm:
      {
        /*const*/ TemplateTypeParmType /*P*/ ty = cast_TemplateTypeParmType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case SubstTemplateTypeParm:
      {
        /*const*/ SubstTemplateTypeParmType /*P*/ ty = cast_SubstTemplateTypeParmType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case SubstTemplateTypeParmPack:
      {
        /*const*/ SubstTemplateTypeParmPackType /*P*/ ty = cast_SubstTemplateTypeParmPackType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case TemplateSpecialization:
      {
        /*const*/ TemplateSpecializationType /*P*/ ty = cast_TemplateSpecializationType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Auto:
      {
        /*const*/ AutoType /*P*/ ty = cast_AutoType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case InjectedClassName:
      {
        /*const*/ InjectedClassNameType /*P*/ ty = cast_InjectedClassNameType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case DependentName:
      {
        /*const*/ DependentNameType /*P*/ ty = cast_DependentNameType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case DependentTemplateSpecialization:
      {
        /*const*/ DependentTemplateSpecializationType /*P*/ ty = cast_DependentTemplateSpecializationType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case PackExpansion:
      {
        /*const*/ PackExpansionType /*P*/ ty = cast_PackExpansionType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case ObjCObject:
      {
        /*const*/ ObjCObjectType /*P*/ ty = cast_ObjCObjectType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case ObjCInterface:
      {
        /*const*/ ObjCInterfaceType /*P*/ ty = cast_ObjCInterfaceType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case ObjCObjectPointer:
      {
        /*const*/ ObjCObjectPointerType /*P*/ ty = cast_ObjCObjectPointerType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Pipe:
      {
        /*const*/ PipeType /*P*/ ty = cast_PipeType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
     case Atomic:
      {
        /*const*/ AtomicType /*P*/ ty = cast_AtomicType(this);
        if (!ty.isSugared()) {
          return new QualType(ty, 0);
        }
        return ty.desugar();
      }
    }
    throw new llvm_unreachable("bad type kind!");
  }


  
  /// Types are partitioned into 3 broad categories (C99 6.2.5p1):
  /// object types, function types, and incomplete types.
  
  /// Return true if this is an incomplete type.
  /// A type that can describe objects, but which lacks information needed to
  /// determine its size (e.g. void, or a fwd declared struct). Clients of this
  /// routine will need to determine if the size is actually required.
  ///
  /// \brief Def If non-null, and the type refers to some kind of declaration
  /// that can be completed (such as a C struct, C++ class, or Objective-C
  /// class), will be set to the declaration.
  
  /// Types are partitioned into 3 broad categories (C99 6.2.5p1):
  /// object types, function types, and incomplete types.
  
  /// Return true if this is an incomplete type.
  /// A type that can describe objects, but which lacks information needed to
  /// determine its size (e.g. void, or a fwd declared struct). Clients of this
  /// routine will need to determine if the size is actually required.
  ///
  /// \brief Def If non-null, and the type refers to some kind of declaration
  /// that can be completed (such as a C struct, C++ class, or Objective-C
  /// class), will be set to the declaration.
  
  /// isIncompleteType - Return true if this is an incomplete type (C99 6.2.5p1)
  /// - a type that can describe objects, but which lacks information needed to
  /// determine its size.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isIncompleteType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*check for Def != null*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1892,
   FQN="clang::Type::isIncompleteType", NM="_ZNK5clang4Type16isIncompleteTypeEPPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type16isIncompleteTypeEPPNS_9NamedDeclE")
  //</editor-fold>
  public boolean isIncompleteType() /*const*/ {
    return isIncompleteType((type$ptr<NamedDecl /*P*/ /*P*/>)null);
  }
  public boolean isIncompleteType(type$ptr<NamedDecl /*P*/ /*P*/> Def/*= null*/) /*const*/ {
    if (Def != null) {
      Def.$set(null);
    }
    switch (CanonicalType.$arrow().getTypeClass()) {
     default:
      return false;
     case Builtin:
      // Void is the only incomplete builtin type.  Per C99 6.2.5p19, it can never
      // be completed.
      return isVoidType();
     case Enum:
      {
        EnumDecl /*P*/ EnumD = cast_EnumType(CanonicalType).getDecl();
        if (Def != null) {
          Def.$set(EnumD);
        }
        
        // An enumeration with fixed underlying type is complete (C++0x 7.2p3).
        if (EnumD.isFixed()) {
          return false;
        }
        
        return !EnumD.isCompleteDefinition();
      }
     case Record:
      {
        // A tagged type (struct/union/enum/class) is incomplete if the decl is a
        // forward declaration, but not a full definition (C99 6.2.5p22).
        RecordDecl /*P*/ Rec = cast_RecordType(CanonicalType).getDecl();
        if (Def != null) {
          Def.$set(Rec);
        }
        return !Rec.isCompleteDefinition();
      }
     case ConstantArray:
      // An array is incomplete if its element type is incomplete
      // (C++ [dcl.array]p1).
      // We don't handle variable arrays (they're not allowed in C++) or
      // dependent-sized arrays (dependent types are never treated as incomplete).
      return cast_ArrayType(CanonicalType).getElementType().$arrow().
          isIncompleteType(Def);
     case IncompleteArray:
      // An array of unknown size is an incomplete type (C99 6.2.5p22).
      return true;
     case MemberPointer:
      {
        // Member pointers in the MS ABI have special behavior in
        // RequireCompleteType: they attach a MSInheritanceAttr to the CXXRecordDecl
        // to indicate which inheritance model to use.
        /*const*/ MemberPointerType /*P*/ MPTy = cast_MemberPointerType(CanonicalType);
        /*const*/ Type /*P*/ ClassTy = MPTy.__getClass();
        // Member pointers with dependent class types don't get special treatment.
        if (ClassTy.isDependentType()) {
          return false;
        }
        /*const*/ CXXRecordDecl /*P*/ RD = ClassTy.getAsCXXRecordDecl();
        final ASTContext /*&*/ Context = RD.getASTContext();
        // Member pointers not in the MS ABI don't get special treatment.
        if (!Context.getTargetInfo().getCXXABI().isMicrosoft()) {
          return false;
        }
        // The inheritance attribute might only be present on the most recent
        // CXXRecordDecl, use that one.
        RD = RD.getMostRecentDecl$Const();
        // Nothing interesting to do if the inheritance attribute is already set.
        if (RD.hasAttr(MSInheritanceAttr.class)) {
          return false;
        }
        return true;
      }
     case ObjCObject:
      return cast_ObjCObjectType(CanonicalType).getBaseType().$arrow().
          isIncompleteType(Def);
     case ObjCInterface:
      {
        // ObjC interfaces are incomplete if they are @class, not @interface.
        ObjCInterfaceDecl /*P*/ Interface = cast_ObjCInterfaceType(CanonicalType).getDecl();
        if (Def != null) {
          Def.$set(Interface);
        }
        return !Interface.hasDefinition();
      }
    }
  }


  
  /// Return true if this is an incomplete or object
  /// type, in other words, not a function type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isIncompleteOrObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1583,
   FQN="clang::Type::isIncompleteOrObjectType", NM="_ZNK5clang4Type24isIncompleteOrObjectTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type24isIncompleteOrObjectTypeEv")
  //</editor-fold>
  public boolean isIncompleteOrObjectType() /*const*/ {
    return !isFunctionType();
  }

  
  /// \brief Determine whether this type is an object type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1588,
   FQN="clang::Type::isObjectType", NM="_ZNK5clang4Type12isObjectTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type12isObjectTypeEv")
  //</editor-fold>
  public boolean isObjectType() /*const*/ {
    // C++ [basic.types]p8:
    //   An object type is a (possibly cv-qualified) type that is not a
    //   function type, not a reference type, and not a void type.
    return !isReferenceType() && !isFunctionType() && !isVoidType();
  }

  
  /// Return true if this is a literal type
  /// (C++11 [basic.types]p10)
  
  /// Return true if this is a literal type
  /// (C++11 [basic.types]p10)
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isLiteralType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2155,
   FQN="clang::Type::isLiteralType", NM="_ZNK5clang4Type13isLiteralTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type13isLiteralTypeERKNS_10ASTContextE")
  //</editor-fold>
  public boolean isLiteralType(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    if (isDependentType()) {
      return false;
    }
    
    // C++1y [basic.types]p10:
    //   A type is a literal type if it is:
    //   -- cv void; or
    if (Ctx.getLangOpts().CPlusPlus14 && isVoidType()) {
      return true;
    }
    
    // C++11 [basic.types]p10:
    //   A type is a literal type if it is:
    //   [...]
    //   -- an array of literal type other than an array of runtime bound; or
    if (isVariableArrayType()) {
      return false;
    }
    /*const*/ Type /*P*/ BaseTy = getBaseElementTypeUnsafe();
    assert ((BaseTy != null)) : "NULL element type";
    
    // Return false for incomplete types after skipping any incomplete array
    // types; those are expressly allowed by the standard and thus our API.
    if (BaseTy.isIncompleteType()) {
      return false;
    }
    
    // C++11 [basic.types]p10:
    //   A type is a literal type if it is:
    //    -- a scalar type; or
    // As an extension, Clang treats vector types and complex types as
    // literal types.
    if (BaseTy.isScalarType() || BaseTy.isVectorType()
       || BaseTy.isAnyComplexType()) {
      return true;
    }
    //    -- a reference type; or
    if (BaseTy.isReferenceType()) {
      return true;
    }
    {
      //    -- a class type that has all of the following properties:
      /*const*/ RecordType /*P*/ RT = BaseTy.<RecordType>getAs$RecordType();
      if ((RT != null)) {
        {
          //    -- a trivial destructor,
          //    -- every constructor call and full-expression in the
          //       brace-or-equal-initializers for non-static data members (if any)
          //       is a constant expression,
          //    -- it is an aggregate type or has at least one constexpr
          //       constructor or constructor template that is not a copy or move
          //       constructor, and
          //    -- all non-static data members and base classes of literal types
          //
          // We resolve DR1361 by ignoring the second bullet.
          /*const*/ CXXRecordDecl /*P*/ ClassDecl = dyn_cast_CXXRecordDecl(RT.getDecl());
          if ((ClassDecl != null)) {
            return ClassDecl.isLiteral();
          }
        }
        
        return true;
      }
    }
    {
      
      // We treat _Atomic T as a literal type if T is a literal type.
      /*const*/ AtomicType /*P*/ AT = BaseTy.getAs(AtomicType.class);
      if ((AT != null)) {
        return AT.getValueType().$arrow().isLiteralType(Ctx);
      }
    }
    
    // If this type hasn't been deduced yet, then conservatively assume that
    // it'll work out to be a literal type.
    if (isa_AutoType(BaseTy.getCanonicalTypeInternal())) {
      return true;
    }
    
    return false;
  }


  
  /// Test if this type is a standard-layout type.
  /// (C++0x [basic.type]p9)
  
  /// Test if this type is a standard-layout type.
  /// (C++0x [basic.type]p9)
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isStandardLayoutType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2221,
   FQN="clang::Type::isStandardLayoutType", NM="_ZNK5clang4Type20isStandardLayoutTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type20isStandardLayoutTypeEv")
  //</editor-fold>
  public boolean isStandardLayoutType() /*const*/ {
    if (isDependentType()) {
      return false;
    }
    
    // C++0x [basic.types]p9:
    //   Scalar types, standard-layout class types, arrays of such types, and
    //   cv-qualified versions of these types are collectively called
    //   standard-layout types.
    /*const*/ Type /*P*/ BaseTy = getBaseElementTypeUnsafe();
    assert ((BaseTy != null)) : "NULL element type";
    
    // Return false for incomplete types after skipping any incomplete array
    // types which are expressly allowed by the standard and thus our API.
    if (BaseTy.isIncompleteType()) {
      return false;
    }
    
    // As an extension, Clang treats vector types as Scalar types.
    if (BaseTy.isScalarType() || BaseTy.isVectorType()) {
      return true;
    }
    {
      /*const*/ RecordType /*P*/ RT = BaseTy.<RecordType>getAs$RecordType();
      if ((RT != null)) {
        {
          /*const*/ CXXRecordDecl /*P*/ ClassDecl = dyn_cast_CXXRecordDecl(RT.getDecl());
          if ((ClassDecl != null)) {
            if (!ClassDecl.isStandardLayout()) {
              return false;
            }
          }
        }
        
        // Default to 'true' for non-C++ class types.
        // FIXME: This is a bit dubious, but plain C structs should trivially meet
        // all the requirements of standard layout classes.
        return true;
      }
    }
    
    // No other types can match.
    return false;
  }


  
  /// Helper methods to distinguish type categories. All type predicates
  /// operate on the canonical type, ignoring typedefs and qualifiers.
  
  /// Returns true if the type is a builtin type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isBuiltinType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5536,
   FQN="clang::Type::isBuiltinType", NM="_ZNK5clang4Type13isBuiltinTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type13isBuiltinTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isBuiltinType() /*const*/ {
    return isa_BuiltinType(CanonicalType);
  }

  
  /// Test for a particular builtin type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isSpecificBuiltinType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5647,
   FQN="clang::Type::isSpecificBuiltinType", NM="_ZNK5clang4Type21isSpecificBuiltinTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type21isSpecificBuiltinTypeEj")
  //</editor-fold>
  public /*inline*/ boolean isSpecificBuiltinType(/*uint*/int K) /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = getAs$BuiltinType();
      if ((BT != null)) {
        if (BT.getKind() == BuiltinType.Kind.valueOf(K)) {
          return true;
        }
      }
    }
    return false;
  }

  
  /// Test for a type which does not represent an actual type-system type but
  /// is instead used as a placeholder for various convenient purposes within
  /// Clang.  All such types are BuiltinTypes.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isPlaceholderType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5654,
   FQN="clang::Type::isPlaceholderType", NM="_ZNK5clang4Type17isPlaceholderTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type17isPlaceholderTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isPlaceholderType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(this);
      if ((BT != null)) {
        return BT.isPlaceholderType();
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsPlaceholderType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5660,
   FQN="clang::Type::getAsPlaceholderType", NM="_ZNK5clang4Type20getAsPlaceholderTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type20getAsPlaceholderTypeEv")
  //</editor-fold>
  public /*inline*/ /*const*/ BuiltinType /*P*/ getAsPlaceholderType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(this);
      if ((BT != null)) {
        if (BT.isPlaceholderType()) {
          return BT;
        }
      }
    }
    return null;
  }

  
  /// Test for a specific placeholder type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isSpecificPlaceholderType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5667,
   FQN="clang::Type::isSpecificPlaceholderType", NM="_ZNK5clang4Type25isSpecificPlaceholderTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type25isSpecificPlaceholderTypeEj")
  //</editor-fold>
  public /*inline*/ boolean isSpecificPlaceholderType(/*uint*/int K) /*const*/ {
    assert (BuiltinType.isPlaceholderTypeKind(BuiltinType.Kind.valueOf(K)));
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(this);
      if ((BT != null)) {
        return (BT.getKind() == BuiltinType.Kind.valueOf(K));
      }
    }
    return false;
  }

  
  /// Test for a placeholder type other than Overload; see
  /// BuiltinType::isNonOverloadPlaceholderType.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isNonOverloadPlaceholderType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5674,
   FQN="clang::Type::isNonOverloadPlaceholderType", NM="_ZNK5clang4Type28isNonOverloadPlaceholderTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type28isNonOverloadPlaceholderTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isNonOverloadPlaceholderType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(this);
      if ((BT != null)) {
        return BT.isNonOverloadPlaceholderType();
      }
    }
    return false;
  }

  
  /// isIntegerType() does *not* include complex integers (a GCC extension).
  /// isComplexIntegerType() can be used to test for complex integers.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5702,
   FQN="clang::Type::isIntegerType", NM="_ZNK5clang4Type13isIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type13isIntegerTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isIntegerType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() >= BuiltinType.Kind.Bool.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.Int128.getValue();
      }
    }
    {
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(CanonicalType);
      if ((ET != null)) {
        // Incomplete enum types are not treated as integer types.
        // FIXME: In C++, enum types are never integer types.
        return IsEnumDeclComplete(ET.getDecl())
           && !IsEnumDeclScoped(ET.getDecl());
      }
    }
    return false;
  }
 // C99 6.2.5p17 (int, char, bool, enum)
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isEnumeralType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5542,
   FQN="clang::Type::isEnumeralType", NM="_ZNK5clang4Type14isEnumeralTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type14isEnumeralTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isEnumeralType() /*const*/ {
    return isa_EnumType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isBooleanType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5743,
   FQN="clang::Type::isBooleanType", NM="_ZNK5clang4Type13isBooleanTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type13isBooleanTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isBooleanType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind() == BuiltinType.Kind.Bool;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isCharType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1656,
   FQN="clang::Type::isCharType", NM="_ZNK5clang4Type10isCharTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type10isCharTypeEv")
  //</editor-fold>
  public boolean isCharType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind() == BuiltinType.Kind.Char_U
           || BT.getKind() == BuiltinType.Kind.UChar
           || BT.getKind() == BuiltinType.Kind.Char_S
           || BT.getKind() == BuiltinType.Kind.SChar;
      }
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isWideCharType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1665,
   FQN="clang::Type::isWideCharType", NM="_ZNK5clang4Type14isWideCharTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type14isWideCharTypeEv")
  //</editor-fold>
  public boolean isWideCharType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind() == BuiltinType.Kind.WChar_S
           || BT.getKind() == BuiltinType.Kind.WChar_U;
      }
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isChar16Type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1672,
   FQN="clang::Type::isChar16Type", NM="_ZNK5clang4Type12isChar16TypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type12isChar16TypeEv")
  //</editor-fold>
  public boolean isChar16Type() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind() == BuiltinType.Kind.Char16;
      }
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isChar32Type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1678,
   FQN="clang::Type::isChar32Type", NM="_ZNK5clang4Type12isChar32TypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type12isChar32TypeEv")
  //</editor-fold>
  public boolean isChar32Type() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind() == BuiltinType.Kind.Char32;
      }
    }
    return false;
  }


  
  /// \brief Determine whether this type is any of the built-in character
  /// types.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isAnyCharacterType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1686,
   FQN="clang::Type::isAnyCharacterType", NM="_ZNK5clang4Type18isAnyCharacterTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type18isAnyCharacterTypeEv")
  //</editor-fold>
  public boolean isAnyCharacterType() /*const*/ {
    /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
    if (!(BT != null)) {
      return false;
    }
    switch (BT.getKind()) {
     default:
      return false;
     case Char_U:
     case UChar:
     case WChar_U:
     case Char16:
     case Char32:
     case Char_S:
     case SChar:
     case WChar_S:
      return true;
    }
  }


  
  /// \brief Determine whether this type is an integral type.
  ///
  /// This routine determines whether the given type is an integral type per 
  /// C++ [basic.fundamental]p7. Although the C standard does not define the
  /// term "integral type", it has a similar term "integer type", and in C++
  /// the two terms are equivalent. However, C's "integer type" includes 
  /// enumeration types, while C++'s "integer type" does not. The \c ASTContext
  /// parameter is used to determine whether we should be following the C or
  /// C++ rules when determining whether this type is an integral/integer type.
  ///
  /// For cases where C permits "an integer type" and C++ permits "an integral
  /// type", use this routine.
  ///
  /// For cases where C permits "an integer type" and C++ permits "an integral
  /// or enumeration type", use \c isIntegralOrEnumerationType() instead. 
  ///
  /// \param Ctx The context in which this type occurs.
  ///
  /// \returns true if the type is considered an integral type, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isIntegralType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1625,
   FQN="clang::Type::isIntegralType", NM="_ZNK5clang4Type14isIntegralTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type14isIntegralTypeERKNS_10ASTContextE")
  //</editor-fold>
  public boolean isIntegralType(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() >= BuiltinType.Kind.Bool.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.Int128.getValue();
      }
    }
    
    // Complete enum types are integral in C.
    if (!Ctx.getLangOpts().CPlusPlus) {
      {
        /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(CanonicalType);
        if ((ET != null)) {
          return ET.getDecl().isComplete();
        }
      }
    }
    
    return false;
  }


  
  /// Determine whether this type is an integral or enumeration type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isIntegralOrEnumerationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5730,
   FQN="clang::Type::isIntegralOrEnumerationType", NM="_ZNK5clang4Type27isIntegralOrEnumerationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type27isIntegralOrEnumerationTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isIntegralOrEnumerationType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() >= BuiltinType.Kind.Bool.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.Int128.getValue();
      }
    }
    {
      
      // Check for a complete enum type; incomplete enum types are not properly an
      // enumeration type in the sense required here.
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(CanonicalType);
      if ((ET != null)) {
        return IsEnumDeclComplete(ET.getDecl());
      }
    }
    
    return false;
  }

  /// Determine whether this type is an integral or unscoped enumeration type.
  /// Determine whether this type is an integral or unscoped enumeration type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isIntegralOrUnscopedEnumerationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1639,
   FQN="clang::Type::isIntegralOrUnscopedEnumerationType", NM="_ZNK5clang4Type35isIntegralOrUnscopedEnumerationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type35isIntegralOrUnscopedEnumerationTypeEv")
  //</editor-fold>
  public boolean isIntegralOrUnscopedEnumerationType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() >= BuiltinType.Kind.Bool.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.Int128.getValue();
      }
    }
    {
      
      // Check for a complete enum type; incomplete enum types are not properly an
      // enumeration type in the sense required here.
      // C++0x: However, if the underlying type of the enum is fixed, it is
      // considered complete.
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(CanonicalType);
      if ((ET != null)) {
        return ET.getDecl().isComplete() && !ET.getDecl().isScoped();
      }
    }
    
    return false;
  }


  
  /// Floating point categories.
  
  /// Floating point categories.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isRealFloatingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1799,
   FQN="clang::Type::isRealFloatingType", NM="_ZNK5clang4Type18isRealFloatingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type18isRealFloatingTypeEv")
  //</editor-fold>
  public boolean isRealFloatingType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.isFloatingPoint();
      }
    }
    return false;
  }
 // C99 6.2.5p10 (float, double, long double)
  /// isComplexType() does *not* include complex integers (a GCC extension).
  /// isComplexIntegerType() can be used to test for complex integers.

  // C99 6.2.5p10 (float, double, long double)
  /// isComplexType() does *not* include complex integers (a GCC extension).
  /// isComplexIntegerType() can be used to test for complex integers.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 397,
   FQN="clang::Type::isComplexType", NM="_ZNK5clang4Type13isComplexTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type13isComplexTypeEv")
  //</editor-fold>
  public boolean isComplexType() /*const*/ {
    {
      /*const*/ ComplexType /*P*/ CT = dyn_cast_ComplexType(CanonicalType);
      if ((CT != null)) {
        return CT.getElementType().$arrow().isFloatingType();
      }
    }
    return false;
  }
 // C99 6.2.5p11 (complex)

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isAnyComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5545,
   FQN="clang::Type::isAnyComplexType", NM="_ZNK5clang4Type16isAnyComplexTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type16isAnyComplexTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isAnyComplexType() /*const*/ {
    return isa_ComplexType(CanonicalType);
  }
 // C99 6.2.5p11 (complex) + Complex Int.
  // C99 6.2.5p11 (complex) + Complex Int.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isFloatingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1783,
   FQN="clang::Type::isFloatingType", NM="_ZNK5clang4Type14isFloatingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type14isFloatingTypeEv")
  //</editor-fold>
  public boolean isFloatingType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() >= BuiltinType.Kind.Half.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.Float128.getValue();
      }
    }
    {
      /*const*/ ComplexType /*P*/ CT = dyn_cast_ComplexType(CanonicalType);
      if ((CT != null)) {
        return CT.getElementType().$arrow().isFloatingType();
      }
    }
    return false;
  }
 // C99 6.2.5p11 (real floating + complex)

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isHalfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5686,
   FQN="clang::Type::isHalfType", NM="_ZNK5clang4Type10isHalfTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type10isHalfTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isHalfType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind() == BuiltinType.Kind.Half;
      }
    }
    // FIXME: Should we allow complex __fp16? Probably not.
    return false;
  }
 // OpenCL 6.1.1.1, NEON (IEEE 754-2008 half)
  // OpenCL 6.1.1.1, NEON (IEEE 754-2008 half)
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isRealType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1805,
   FQN="clang::Type::isRealType", NM="_ZNK5clang4Type10isRealTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type10isRealTypeEv")
  //</editor-fold>
  public boolean isRealType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() >= BuiltinType.Kind.Bool.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.Float128.getValue();
      }
    }
    {
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(CanonicalType);
      if ((ET != null)) {
        return ET.getDecl().isComplete() && !ET.getDecl().isScoped();
      }
    }
    return false;
  }
 // C99 6.2.5p17 (real floating + integer)

  // C99 6.2.5p17 (real floating + integer)
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isArithmeticType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1814,
   FQN="clang::Type::isArithmeticType", NM="_ZNK5clang4Type16isArithmeticTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type16isArithmeticTypeEv")
  //</editor-fold>
  public boolean isArithmeticType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() >= BuiltinType.Kind.Bool.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.Float128.getValue();
      }
    }
    {
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(CanonicalType);
      if ((ET != null)) {
        // GCC allows forward declaration of enum types (forbid by C99 6.7.2.3p2).
        // If a body isn't seen by the time we get here, return false.
        //
        // C++0x: Enumerations are not arithmetic types. For now, just return
        // false for scoped enumerations since that will disable any
        // unwanted implicit conversions.
        return !ET.getDecl().isScoped() && ET.getDecl().isComplete();
      }
    }
    return isa_ComplexType(CanonicalType);
  }
 // C99 6.2.5p18 (integer + floating)

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isVoidType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5680,
   FQN="clang::Type::isVoidType", NM="_ZNK5clang4Type10isVoidTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type10isVoidTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isVoidType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind() == BuiltinType.Kind.Void;
      }
    }
    return false;
  }
 // C99 6.2.5p19
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isScalarType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5715,
   FQN="clang::Type::isScalarType", NM="_ZNK5clang4Type12isScalarTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type12isScalarTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isScalarType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() > BuiltinType.Kind.Void.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.NullPtr.getValue();
      }
    }
    {
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(CanonicalType);
      if ((ET != null)) {
        // Enums are scalar types, but only if they are defined.  Incomplete enums
        // are not treated as scalar types.
        return IsEnumDeclComplete(ET.getDecl());
      }
    }
    return isa_PointerType(CanonicalType)
       || isa_BlockPointerType(CanonicalType)
       || isa_MemberPointerType(CanonicalType)
       || isa_ComplexType(CanonicalType)
       || isa_ObjCObjectPointerType(CanonicalType);
  }
 // C99 6.2.5p21 (arithmetic + pointers)
  // C99 6.2.5p21 (arithmetic + pointers)
  
  /// \brief Determines whether the type is a C++ aggregate type or C
  /// aggregate or union type.
  ///
  /// An aggregate type is an array or a class type (struct, union, or
  /// class) that has no user-declared constructors, no private or
  /// protected non-static data members, no base classes, and no virtual
  /// functions (C++ [dcl.init.aggr]p1). The notion of an aggregate type
  /// subsumes the notion of C aggregates (C99 6.2.5p21) because it also
  /// includes union types.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isAggregateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1868,
   FQN="clang::Type::isAggregateType", NM="_ZNK5clang4Type15isAggregateTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type15isAggregateTypeEv")
  //</editor-fold>
  public boolean isAggregateType() /*const*/ {
    {
      /*const*/ RecordType /*P*/ Record = dyn_cast_RecordType(CanonicalType);
      if ((Record != null)) {
        {
          CXXRecordDecl /*P*/ ClassDecl = dyn_cast_CXXRecordDecl(Record.getDecl());
          if ((ClassDecl != null)) {
            return ClassDecl.isAggregate();
          }
        }
        
        return true;
      }
    }
    
    return isa_ArrayType(CanonicalType);
  }


  
  /// Tests whether the type is categorized as a fundamental type.
  ///
  /// \returns True for types specified in C++0x [basic.fundamental].
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isFundamentalType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5447,
   FQN="clang::Type::isFundamentalType", NM="_ZNK5clang4Type17isFundamentalTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type17isFundamentalTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isFundamentalType() /*const*/ {
    return isVoidType()
      // FIXME: It's really annoying that we don't have an
      // 'isArithmeticType()' which agrees with the standard definition.
       || (isArithmeticType() && !isEnumeralType());
  }

  
  /// Tests whether the type is categorized as a compound type.
  ///
  /// \returns True for types specified in C++0x [basic.compound].
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isCompoundType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5457,
   FQN="clang::Type::isCompoundType", NM="_ZNK5clang4Type14isCompoundTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type14isCompoundTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isCompoundType() /*const*/ {
    // C++0x [basic.compound]p1:
    //   Compound types can be constructed in the following ways:
    //    -- arrays of objects of a given type [...];
    return isArrayType()
      //    -- functions, which have parameters of given types [...];
       || isFunctionType()
      //    -- pointers to void or objects or functions [...];
       || isPointerType()
      //    -- references to objects or functions of a given type. [...]
       || isReferenceType()
      //    -- classes containing a sequence of objects of various types, [...];
       || isRecordType()
      //    -- unions, which are classes capable of containing objects of different
      //               types at different times;
       || isUnionType()
      //    -- enumerations, which comprise a set of named constant values. [...];
       || isEnumeralType()
      //    -- pointers to non-static class members, [...].
       || isMemberPointerType();
  }

  
  // Type Predicates: Check to see if this type is structurally the specified
  // type, ignoring typedefs and qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5479,
   FQN="clang::Type::isFunctionType", NM="_ZNK5clang4Type14isFunctionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type14isFunctionTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isFunctionType() /*const*/ {
    return isa_FunctionType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isFunctionNoProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1661,
   FQN="clang::Type::isFunctionNoProtoType", NM="_ZNK5clang4Type21isFunctionNoProtoTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type21isFunctionNoProtoTypeEv")
  //</editor-fold>
  public boolean isFunctionNoProtoType() /*const*/ {
    return (getAs(FunctionNoProtoType.class) != null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1662,
   FQN="clang::Type::isFunctionProtoType", NM="_ZNK5clang4Type19isFunctionProtoTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type19isFunctionProtoTypeEv")
  //</editor-fold>
  public boolean isFunctionProtoType() /*const*/ {
    return (getAs(FunctionProtoType.class) != null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5482,
   FQN="clang::Type::isPointerType", NM="_ZNK5clang4Type13isPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type13isPointerTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isPointerType() /*const*/ {
    return isa_PointerType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isAnyPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5485,
   FQN="clang::Type::isAnyPointerType", NM="_ZNK5clang4Type16isAnyPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type16isAnyPointerTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isAnyPointerType() /*const*/ {
    return isPointerType() || isObjCObjectPointerType();
  }
 // Any C pointer or ObjC object pointer
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5488,
   FQN="clang::Type::isBlockPointerType", NM="_ZNK5clang4Type18isBlockPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type18isBlockPointerTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isBlockPointerType() /*const*/ {
    return isa_BlockPointerType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isVoidPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 385,
   FQN="clang::Type::isVoidPointerType", NM="_ZNK5clang4Type17isVoidPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type17isVoidPointerTypeEv")
  //</editor-fold>
  public boolean isVoidPointerType() /*const*/ {
    {
      /*const*/ PointerType /*P*/ PT = getAs(PointerType.class);
      if ((PT != null)) {
        return PT.getPointeeType().$arrow().isVoidType();
      }
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5491,
   FQN="clang::Type::isReferenceType", NM="_ZNK5clang4Type15isReferenceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type15isReferenceTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isReferenceType() /*const*/ {
    return isa_ReferenceType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isLValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5494,
   FQN="clang::Type::isLValueReferenceType", NM="_ZNK5clang4Type21isLValueReferenceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type21isLValueReferenceTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isLValueReferenceType() /*const*/ {
    return isa_LValueReferenceType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isRValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5497,
   FQN="clang::Type::isRValueReferenceType", NM="_ZNK5clang4Type21isRValueReferenceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type21isRValueReferenceTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isRValueReferenceType() /*const*/ {
    return isa_RValueReferenceType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isFunctionPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5500,
   FQN="clang::Type::isFunctionPointerType", NM="_ZNK5clang4Type21isFunctionPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type21isFunctionPointerTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isFunctionPointerType() /*const*/ {
    {
      /*const*/ PointerType /*P*/ T = getAs(PointerType.class);
      if ((T != null)) {
        return T.getPointeeType().$arrow().isFunctionType();
      } else {
        return false;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5506,
   FQN="clang::Type::isMemberPointerType", NM="_ZNK5clang4Type19isMemberPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type19isMemberPointerTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isMemberPointerType() /*const*/ {
    return isa_MemberPointerType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isMemberFunctionPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5509,
   FQN="clang::Type::isMemberFunctionPointerType", NM="_ZNK5clang4Type27isMemberFunctionPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type27isMemberFunctionPointerTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isMemberFunctionPointerType() /*const*/ {
    {
      /*const*/ MemberPointerType /*P*/ T = getAs(MemberPointerType.class);
      if ((T != null)) {
        return T.isMemberFunctionPointer();
      } else {
        return false;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isMemberDataPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5515,
   FQN="clang::Type::isMemberDataPointerType", NM="_ZNK5clang4Type23isMemberDataPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type23isMemberDataPointerTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isMemberDataPointerType() /*const*/ {
    {
      /*const*/ MemberPointerType /*P*/ T = getAs(MemberPointerType.class);
      if ((T != null)) {
        return T.isMemberDataPointer();
      } else {
        return false;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5521,
   FQN="clang::Type::isArrayType", NM="_ZNK5clang4Type11isArrayTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type11isArrayTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isArrayType() /*const*/ {
    return isa_ArrayType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5524,
   FQN="clang::Type::isConstantArrayType", NM="_ZNK5clang4Type19isConstantArrayTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type19isConstantArrayTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isConstantArrayType() /*const*/ {
    return isa_ConstantArrayType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isIncompleteArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5527,
   FQN="clang::Type::isIncompleteArrayType", NM="_ZNK5clang4Type21isIncompleteArrayTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type21isIncompleteArrayTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isIncompleteArrayType() /*const*/ {
    return isa_IncompleteArrayType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isVariableArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5530,
   FQN="clang::Type::isVariableArrayType", NM="_ZNK5clang4Type19isVariableArrayTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type19isVariableArrayTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isVariableArrayType() /*const*/ {
    return isa_VariableArrayType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isDependentSizedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5533,
   FQN="clang::Type::isDependentSizedArrayType", NM="_ZNK5clang4Type25isDependentSizedArrayTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type25isDependentSizedArrayTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isDependentSizedArrayType() /*const*/ {
    return isa_DependentSizedArrayType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5539,
   FQN="clang::Type::isRecordType", NM="_ZNK5clang4Type12isRecordTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type12isRecordTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isRecordType() /*const*/ {
    return isa_RecordType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isClassType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 358,
   FQN="clang::Type::isClassType", NM="_ZNK5clang4Type11isClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type11isClassTypeEv")
  //</editor-fold>
  public boolean isClassType() /*const*/ {
    {
      /*const*/ RecordType /*P*/ RT = getAs$RecordType();
      if ((RT != null)) {
        return RT.getDecl().isClass();
      }
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isStructureType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 363,
   FQN="clang::Type::isStructureType", NM="_ZNK5clang4Type15isStructureTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type15isStructureTypeEv")
  //</editor-fold>
  public boolean isStructureType() /*const*/ {
    {
      /*const*/ RecordType /*P*/ RT = getAs$RecordType();
      if ((RT != null)) {
        return RT.getDecl().isStruct();
      }
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCBoxableRecordType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 368,
   FQN="clang::Type::isObjCBoxableRecordType", NM="_ZNK5clang4Type23isObjCBoxableRecordTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type23isObjCBoxableRecordTypeEv")
  //</editor-fold>
  public boolean isObjCBoxableRecordType() /*const*/ {
    {
      /*const*/ RecordType /*P*/ RT = getAs$RecordType();
      if ((RT != null)) {
        return RT.getDecl().hasAttr(ObjCBoxableAttr.class);
      }
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isInterfaceType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 373,
   FQN="clang::Type::isInterfaceType", NM="_ZNK5clang4Type15isInterfaceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type15isInterfaceTypeEv")
  //</editor-fold>
  public boolean isInterfaceType() /*const*/ {
    {
      /*const*/ RecordType /*P*/ RT = getAs$RecordType();
      if ((RT != null)) {
        return RT.getDecl().isInterface();
      }
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isStructureOrClassType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 378,
   FQN="clang::Type::isStructureOrClassType", NM="_ZNK5clang4Type22isStructureOrClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type22isStructureOrClassTypeEv")
  //</editor-fold>
  public boolean isStructureOrClassType() /*const*/ {
    {
      /*const*/ RecordType /*P*/ RT = getAs$RecordType();
      if ((RT != null)) {
        RecordDecl /*P*/ RD = RT.getDecl();
        return RD.isStruct() || RD.isClass() || RD.isInterface();
      }
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isUnionType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 391,
   FQN="clang::Type::isUnionType", NM="_ZNK5clang4Type11isUnionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type11isUnionTypeEv")
  //</editor-fold>
  public boolean isUnionType() /*const*/ {
    {
      /*const*/ RecordType /*P*/ RT = getAs$RecordType();
      if ((RT != null)) {
        return RT.getDecl().isUnion();
      }
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isComplexIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 403,
   FQN="clang::Type::isComplexIntegerType", NM="_ZNK5clang4Type20isComplexIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type20isComplexIntegerTypeEv")
  //</editor-fold>
  public boolean isComplexIntegerType() /*const*/ {
    // Check for GCC complex integer extension.
    return (getAsComplexIntegerType() != null);
  }
 // GCC _Complex integer type.

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5548,
   FQN="clang::Type::isVectorType", NM="_ZNK5clang4Type12isVectorTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type12isVectorTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isVectorType() /*const*/ {
    return isa_VectorType(CanonicalType);
  }
 // GCC vector type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5551,
   FQN="clang::Type::isExtVectorType", NM="_ZNK5clang4Type15isExtVectorTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type15isExtVectorTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isExtVectorType() /*const*/ {
    return isa_ExtVectorType(CanonicalType);
  }
 // Extended vector type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCObjectPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5554,
   FQN="clang::Type::isObjCObjectPointerType", NM="_ZNK5clang4Type23isObjCObjectPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type23isObjCObjectPointerTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isObjCObjectPointerType() /*const*/ {
    return isa_ObjCObjectPointerType(CanonicalType);
  }
 // pointer to ObjC object
  // pointer to ObjC object
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCRetainableType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3699,
   FQN="clang::Type::isObjCRetainableType", NM="_ZNK5clang4Type20isObjCRetainableTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type20isObjCRetainableTypeEv")
  //</editor-fold>
  public boolean isObjCRetainableType() /*const*/ {
    return isObjCObjectPointerType()
       || isBlockPointerType()
       || isObjCNSObjectType();
  }
 // ObjC object or block pointer

  // ObjC object or block pointer
  
  /// Returns true if objects of this type have lifetime semantics under
  /// ARC.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCLifetimeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3718,
   FQN="clang::Type::isObjCLifetimeType", NM="_ZNK5clang4Type18isObjCLifetimeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type18isObjCLifetimeTypeEv")
  //</editor-fold>
  public boolean isObjCLifetimeType() /*const*/ {
    /*const*/ Type /*P*/ type = this;
    {
      /*const*/ ArrayType /*P*/ array;
      while (((/*P*/ array = type.getAsArrayTypeUnsafe()) != null)) {
        type = array.getElementType().getTypePtr();
      }
    }
    return type.isObjCRetainableType();
  }
 // (array of)* retainable type

  // (array of)* retainable type
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCIndirectLifetimeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3704,
   FQN="clang::Type::isObjCIndirectLifetimeType", NM="_ZNK5clang4Type26isObjCIndirectLifetimeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type26isObjCIndirectLifetimeTypeEv")
  //</editor-fold>
  public boolean isObjCIndirectLifetimeType() /*const*/ {
    if (isObjCLifetimeType()) {
      return true;
    }
    {
      /*const*/ PointerType /*P*/ OPT = getAs(PointerType.class);
      if ((OPT != null)) {
        return OPT.getPointeeType().$arrow().isObjCIndirectLifetimeType();
      }
    }
    {
      /*const*/ ReferenceType /*P*/ Ref = getAs(ReferenceType.class);
      if ((Ref != null)) {
        return Ref.getPointeeType().$arrow().isObjCIndirectLifetimeType();
      }
    }
    {
      /*const*/ MemberPointerType /*P*/ MemPtr = getAs(MemberPointerType.class);
      if ((MemPtr != null)) {
        return MemPtr.getPointeeType().$arrow().isObjCIndirectLifetimeType();
      }
    }
    return false;
  }
 // (pointer to)* lifetime type

  // (pointer to)* lifetime type
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCNSObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3689,
   FQN="clang::Type::isObjCNSObjectType", NM="_ZNK5clang4Type18isObjCNSObjectTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type18isObjCNSObjectTypeEv")
  //</editor-fold>
  public boolean isObjCNSObjectType() /*const*/ {
    {
      /*const*/ TypedefType /*P*/ typedefType = dyn_cast_TypedefType(this);
      if ((typedefType != null)) {
        return typedefType.getDecl().hasAttr(ObjCNSObjectAttr.class);
      }
    }
    return false;
  }
 // __attribute__((NSObject))

  // __attribute__((NSObject))
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCIndependentClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3694,
   FQN="clang::Type::isObjCIndependentClassType", NM="_ZNK5clang4Type26isObjCIndependentClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type26isObjCIndependentClassTypeEv")
  //</editor-fold>
  public boolean isObjCIndependentClassType() /*const*/ {
    {
      /*const*/ TypedefType /*P*/ typedefType = dyn_cast_TypedefType(this);
      if ((typedefType != null)) {
        return typedefType.getDecl().hasAttr(ObjCIndependentClassAttr.class);
      }
    }
    return false;
  }
 // __attribute__((objc_independent_class))
  // FIXME: change this to 'raw' interface type, so we can used 'interface' type
  // for the common case.

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5557,
   FQN="clang::Type::isObjCObjectType", NM="_ZNK5clang4Type16isObjCObjectTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type16isObjCObjectTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isObjCObjectType() /*const*/ {
    return isa_ObjCObjectType(CanonicalType);
  }
 // NSString or typeof(*(id)0)
  // NSString or typeof(*(id)0)
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCQualifiedInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1474,
   FQN="clang::Type::isObjCQualifiedInterfaceType", NM="_ZNK5clang4Type28isObjCQualifiedInterfaceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type28isObjCQualifiedInterfaceTypeEv")
  //</editor-fold>
  public boolean isObjCQualifiedInterfaceType() /*const*/ {
    return getAsObjCQualifiedInterfaceType() != null;
  }
 // NSString<foo>

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCQualifiedIdType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5568,
   FQN="clang::Type::isObjCQualifiedIdType", NM="_ZNK5clang4Type21isObjCQualifiedIdTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type21isObjCQualifiedIdTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isObjCQualifiedIdType() /*const*/ {
    {
      /*const*/ ObjCObjectPointerType /*P*/ OPT = getAs(ObjCObjectPointerType.class);
      if ((OPT != null)) {
        return OPT.isObjCQualifiedIdType();
      }
    }
    return false;
  }
 // id<foo>
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCQualifiedClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5573,
   FQN="clang::Type::isObjCQualifiedClassType", NM="_ZNK5clang4Type24isObjCQualifiedClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type24isObjCQualifiedClassTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isObjCQualifiedClassType() /*const*/ {
    {
      /*const*/ ObjCObjectPointerType /*P*/ OPT = getAs(ObjCObjectPointerType.class);
      if ((OPT != null)) {
        return OPT.isObjCQualifiedClassType();
      }
    }
    return false;
  }
 // Class<foo>
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCObjectOrInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5560,
   FQN="clang::Type::isObjCObjectOrInterfaceType", NM="_ZNK5clang4Type27isObjCObjectOrInterfaceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type27isObjCObjectOrInterfaceTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isObjCObjectOrInterfaceType() /*const*/ {
    return isa_ObjCInterfaceType(CanonicalType)
       || isa_ObjCObjectType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCIdType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5578,
   FQN="clang::Type::isObjCIdType", NM="_ZNK5clang4Type12isObjCIdTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type12isObjCIdTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isObjCIdType() /*const*/ {
    {
      /*const*/ ObjCObjectPointerType /*P*/ OPT = getAs(ObjCObjectPointerType.class);
      if ((OPT != null)) {
        return OPT.isObjCIdType();
      }
    }
    return false;
  }
 // id
  // id
  
  /// Was this type written with the special inert-in-MRC __unsafe_unretained
  /// qualifier?
  ///
  /// This approximates the answer to the following question: if this
  /// translation unit were compiled in ARC, would this type be qualified
  /// with __unsafe_unretained?
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCInertUnsafeUnretainedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 519,
   FQN="clang::Type::isObjCInertUnsafeUnretainedType", NM="_ZNK5clang4Type31isObjCInertUnsafeUnretainedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type31isObjCInertUnsafeUnretainedTypeEv")
  //</editor-fold>
  public boolean isObjCInertUnsafeUnretainedType() /*const*/ {
    /*const*/ Type /*P*/ cur = this;
    while (true) {
      {
        /*const*/ AttributedType /*P*/ attributed = dyn_cast_AttributedType(cur);
        if ((attributed != null)) {
          if (attributed.getAttrKind()
             == AttributedType.Kind.attr_objc_inert_unsafe_unretained) {
            return true;
          }
        }
      }
      
      // Single-step desugar until we run out of sugar.
      QualType next = cur.getLocallyUnqualifiedSingleStepDesugaredType();
      if (next.getTypePtr() == cur) {
        return false;
      }
      cur = next.getTypePtr();
    }
  }


  
  /// Whether the type is Objective-C 'id' or a __kindof type of an
  /// object type, e.g., __kindof NSView * or __kindof id
  /// <NSCopying>.
  ///
  /// \param bound Will be set to the bound on non-id subtype types,
  /// which will be (possibly specialized) Objective-C class type, or
  /// null for 'id.
  
  /// Whether the type is Objective-C 'id' or a __kindof type of an
  /// object type, e.g., __kindof NSView * or __kindof id
  /// <NSCopying>.
  ///
  /// \param bound Will be set to the bound on non-id subtype types,
  /// which will be (possibly specialized) Objective-C class type, or
  /// null for 'id.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCIdOrObjectKindOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 470,
   FQN="clang::Type::isObjCIdOrObjectKindOfType", NM="_ZNK5clang4Type26isObjCIdOrObjectKindOfTypeERKNS_10ASTContextERPKNS_14ObjCObjectTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type26isObjCIdOrObjectKindOfTypeERKNS_10ASTContextERPKNS_14ObjCObjectTypeE")
  //</editor-fold>
  public boolean isObjCIdOrObjectKindOfType(final /*const*/ ASTContext /*&*/ ctx, 
                            final type$ref</*const*/ ObjCObjectType /*P*/ /*&*/> bound) /*const*/ {
    bound.$set(null);
    
    /*const*/ ObjCObjectPointerType /*P*/ OPT = getAs(ObjCObjectPointerType.class);
    if (!(OPT != null)) {
      return false;
    }
    
    // Easy case: id.
    if (OPT.isObjCIdType()) {
      return true;
    }
    
    // If it's not a __kindof type, reject it now.
    if (!OPT.isKindOfType()) {
      return false;
    }
    
    // If it's Class or qualified Class, it's not an object type.
    if (OPT.isObjCClassType() || OPT.isObjCQualifiedClassType()) {
      return false;
    }
    
    // Figure out the type bound for the __kindof type.
    bound.$set(OPT.getObjectType().stripObjCKindOfTypeAndQuals(ctx).$arrow().getAs(ObjCObjectType.class));
    return true;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5583,
   FQN="clang::Type::isObjCClassType", NM="_ZNK5clang4Type15isObjCClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type15isObjCClassTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isObjCClassType() /*const*/ {
    {
      /*const*/ ObjCObjectPointerType /*P*/ OPT = getAs(ObjCObjectPointerType.class);
      if ((OPT != null)) {
        return OPT.isObjCClassType();
      }
    }
    return false;
  }
 // Class
  
  /// Whether the type is Objective-C 'Class' or a __kindof type of an
  /// Class type, e.g., __kindof Class <NSCopying>.
  ///
  /// Unlike \c isObjCIdOrObjectKindOfType, there is no relevant bound
  /// here because Objective-C's type system cannot express "a class
  /// object for a subclass of NSFoo".
  // Class
  
  /// Whether the type is Objective-C 'Class' or a __kindof type of an
  /// Class type, e.g., __kindof Class <NSCopying>.
  ///
  /// Unlike \c isObjCIdOrObjectKindOfType, there is no relevant bound
  /// here because Objective-C's type system cannot express "a class
  /// object for a subclass of NSFoo".
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCClassOrClassKindOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 496,
   FQN="clang::Type::isObjCClassOrClassKindOfType", NM="_ZNK5clang4Type28isObjCClassOrClassKindOfTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type28isObjCClassOrClassKindOfTypeEv")
  //</editor-fold>
  public boolean isObjCClassOrClassKindOfType() /*const*/ {
    /*const*/ ObjCObjectPointerType /*P*/ OPT = getAs(ObjCObjectPointerType.class);
    if (!(OPT != null)) {
      return false;
    }
    
    // Easy case: Class.
    if (OPT.isObjCClassType()) {
      return true;
    }
    
    // If it's not a __kindof type, reject it now.
    if (!OPT.isKindOfType()) {
      return false;
    }
    
    // If it's Class or qualified Class, it's a class __kindof type.
    return OPT.isObjCClassType() || OPT.isObjCQualifiedClassType();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isBlockCompatibleObjCPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3630,
   FQN="clang::Type::isBlockCompatibleObjCPointerType", NM="_ZNK5clang4Type32isBlockCompatibleObjCPointerTypeERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type32isBlockCompatibleObjCPointerTypeERNS_10ASTContextE")
  //</editor-fold>
  public boolean isBlockCompatibleObjCPointerType(final ASTContext /*&*/ ctx) /*const*/ {
    /*const*/ ObjCObjectPointerType /*P*/ objcPtr = getAs(ObjCObjectPointerType.class);
    if (!(objcPtr != null)) {
      return false;
    }
    if (objcPtr.isObjCIdType()) {
      // id is always okay.
      return true;
    }
    {
      
      // Blocks are NSObjects.
      ObjCInterfaceDecl /*P*/ iface = objcPtr.getInterfaceDecl();
      if ((iface != null)) {
        if (iface.getIdentifier() != ctx.getNSObjectName()) {
          return false;
        }
        // Continue to check qualifiers, below.
      } else if (objcPtr.isObjCQualifiedIdType()) {
        // Continue to check qualifiers, below.
      } else {
        return false;
      }
    }
    
    // Check protocol qualifiers.
    for (ObjCProtocolDecl /*P*/ proto : objcPtr.quals()) {
      // Blocks conform to NSObject and NSCopying.
      if (proto.getIdentifier() != ctx.getNSObjectName()
         && proto.getIdentifier() != ctx.getNSCopyingName()) {
        return false;
      }
    }
    
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCSelType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5588,
   FQN="clang::Type::isObjCSelType", NM="_ZNK5clang4Type13isObjCSelTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type13isObjCSelTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isObjCSelType() /*const*/ {
    {
      /*const*/ PointerType /*P*/ OPT = getAs(PointerType.class);
      if ((OPT != null)) {
        return OPT.getPointeeType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.ObjCSel.getValue());
      }
    }
    return false;
  }
 // Class
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCBuiltinType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5593,
   FQN="clang::Type::isObjCBuiltinType", NM="_ZNK5clang4Type17isObjCBuiltinTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type17isObjCBuiltinTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isObjCBuiltinType() /*const*/ {
    return isObjCIdType() || isObjCClassType() || isObjCSelType();
  }
 // 'id' or 'Class'
  // 'id' or 'Class'
  
  /// \brief Determine whether the given type T is a "bridgable" Objective-C type,
  /// which is either an Objective-C object pointer type or an 
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCARCBridgableType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3727,
   FQN="clang::Type::isObjCARCBridgableType", NM="_ZNK5clang4Type22isObjCARCBridgableTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type22isObjCARCBridgableTypeEv")
  //</editor-fold>
  public boolean isObjCARCBridgableType() /*const*/ {
    return isObjCObjectPointerType() || isBlockPointerType();
  }


  
  /// \brief Determine whether the given type T is a "bridgeable" C type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isCARCBridgableType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3732,
   FQN="clang::Type::isCARCBridgableType", NM="_ZNK5clang4Type19isCARCBridgableTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type19isCARCBridgableTypeEv")
  //</editor-fold>
  public boolean isCARCBridgableType() /*const*/ {
    /*const*/ PointerType /*P*/ Pointer = getAs(PointerType.class);
    if (!(Pointer != null)) {
      return false;
    }
    
    QualType Pointee = Pointer.getPointeeType();
    return Pointee.$arrow().isVoidType() || Pointee.$arrow().isRecordType();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::isTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5643,
   FQN="clang::Type::isTemplateTypeParmType", NM="_ZNK5clang4Type22isTemplateTypeParmTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type22isTemplateTypeParmTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isTemplateTypeParmType() /*const*/ {
    return isa_TemplateTypeParmType(CanonicalType);
  }
 // C++ template type parameter
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isNullPtrType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5693,
   FQN="clang::Type::isNullPtrType", NM="_ZNK5clang4Type13isNullPtrTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type13isNullPtrTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isNullPtrType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = getAs$BuiltinType();
      if ((BT != null)) {
        return BT.getKind() == BuiltinType.Kind.NullPtr;
      }
    }
    return false;
  }
 // C++0x nullptr_t
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isAtomicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5564,
   FQN="clang::Type::isAtomicType", NM="_ZNK5clang4Type12isAtomicTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type12isAtomicTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isAtomicType() /*const*/ {
    return isa_AtomicType(CanonicalType);
  }
 // C11 _Atomic()
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage1dROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 39,
   FQN="clang::Type::isOCLImage1dROType", NM="_ZNK5clang4Type18isOCLImage1dROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type18isOCLImage1dROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage1dROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage1dRO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage1dArrayROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 40,
   FQN="clang::Type::isOCLImage1dArrayROType", NM="_ZNK5clang4Type23isOCLImage1dArrayROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type23isOCLImage1dArrayROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage1dArrayROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage1dArrayRO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage1dBufferROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 41,
   FQN="clang::Type::isOCLImage1dBufferROType", NM="_ZNK5clang4Type24isOCLImage1dBufferROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type24isOCLImage1dBufferROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage1dBufferROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage1dBufferRO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 42,
   FQN="clang::Type::isOCLImage2dROType", NM="_ZNK5clang4Type18isOCLImage2dROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type18isOCLImage2dROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dRO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 43,
   FQN="clang::Type::isOCLImage2dArrayROType", NM="_ZNK5clang4Type23isOCLImage2dArrayROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type23isOCLImage2dArrayROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayRO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dDepthROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 44,
   FQN="clang::Type::isOCLImage2dDepthROType", NM="_ZNK5clang4Type23isOCLImage2dDepthROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type23isOCLImage2dDepthROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dDepthROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dDepthRO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayDepthROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 45,
   FQN="clang::Type::isOCLImage2dArrayDepthROType", NM="_ZNK5clang4Type28isOCLImage2dArrayDepthROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type28isOCLImage2dArrayDepthROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayDepthROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayDepthRO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dMSAAROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 46,
   FQN="clang::Type::isOCLImage2dMSAAROType", NM="_ZNK5clang4Type22isOCLImage2dMSAAROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type22isOCLImage2dMSAAROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dMSAAROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dMSAARO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayMSAAROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 47,
   FQN="clang::Type::isOCLImage2dArrayMSAAROType", NM="_ZNK5clang4Type27isOCLImage2dArrayMSAAROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type27isOCLImage2dArrayMSAAROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayMSAAROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayMSAARO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dMSAADepthROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 48,
   FQN="clang::Type::isOCLImage2dMSAADepthROType", NM="_ZNK5clang4Type27isOCLImage2dMSAADepthROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type27isOCLImage2dMSAADepthROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dMSAADepthROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dMSAADepthRO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayMSAADepthROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 49,
   FQN="clang::Type::isOCLImage2dArrayMSAADepthROType", NM="_ZNK5clang4Type32isOCLImage2dArrayMSAADepthROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type32isOCLImage2dArrayMSAADepthROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayMSAADepthROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayMSAADepthRO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage3dROType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 50,
   FQN="clang::Type::isOCLImage3dROType", NM="_ZNK5clang4Type18isOCLImage3dROTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type18isOCLImage3dROTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage3dROType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage3dRO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage1dWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 52,
   FQN="clang::Type::isOCLImage1dWOType", NM="_ZNK5clang4Type18isOCLImage1dWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type18isOCLImage1dWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage1dWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage1dWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage1dArrayWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 53,
   FQN="clang::Type::isOCLImage1dArrayWOType", NM="_ZNK5clang4Type23isOCLImage1dArrayWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type23isOCLImage1dArrayWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage1dArrayWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage1dArrayWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage1dBufferWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 54,
   FQN="clang::Type::isOCLImage1dBufferWOType", NM="_ZNK5clang4Type24isOCLImage1dBufferWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type24isOCLImage1dBufferWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage1dBufferWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage1dBufferWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 55,
   FQN="clang::Type::isOCLImage2dWOType", NM="_ZNK5clang4Type18isOCLImage2dWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type18isOCLImage2dWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 56,
   FQN="clang::Type::isOCLImage2dArrayWOType", NM="_ZNK5clang4Type23isOCLImage2dArrayWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type23isOCLImage2dArrayWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dDepthWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 57,
   FQN="clang::Type::isOCLImage2dDepthWOType", NM="_ZNK5clang4Type23isOCLImage2dDepthWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type23isOCLImage2dDepthWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dDepthWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dDepthWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayDepthWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 58,
   FQN="clang::Type::isOCLImage2dArrayDepthWOType", NM="_ZNK5clang4Type28isOCLImage2dArrayDepthWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type28isOCLImage2dArrayDepthWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayDepthWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayDepthWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dMSAAWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 59,
   FQN="clang::Type::isOCLImage2dMSAAWOType", NM="_ZNK5clang4Type22isOCLImage2dMSAAWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type22isOCLImage2dMSAAWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dMSAAWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dMSAAWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayMSAAWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 60,
   FQN="clang::Type::isOCLImage2dArrayMSAAWOType", NM="_ZNK5clang4Type27isOCLImage2dArrayMSAAWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type27isOCLImage2dArrayMSAAWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayMSAAWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayMSAAWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dMSAADepthWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 61,
   FQN="clang::Type::isOCLImage2dMSAADepthWOType", NM="_ZNK5clang4Type27isOCLImage2dMSAADepthWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type27isOCLImage2dMSAADepthWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dMSAADepthWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dMSAADepthWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayMSAADepthWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 62,
   FQN="clang::Type::isOCLImage2dArrayMSAADepthWOType", NM="_ZNK5clang4Type32isOCLImage2dArrayMSAADepthWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type32isOCLImage2dArrayMSAADepthWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayMSAADepthWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayMSAADepthWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage3dWOType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 63,
   FQN="clang::Type::isOCLImage3dWOType", NM="_ZNK5clang4Type18isOCLImage3dWOTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type18isOCLImage3dWOTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage3dWOType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage3dWO.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage1dRWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 65,
   FQN="clang::Type::isOCLImage1dRWType", NM="_ZNK5clang4Type18isOCLImage1dRWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type18isOCLImage1dRWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage1dRWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage1dRW.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage1dArrayRWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 66,
   FQN="clang::Type::isOCLImage1dArrayRWType", NM="_ZNK5clang4Type23isOCLImage1dArrayRWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type23isOCLImage1dArrayRWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage1dArrayRWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage1dArrayRW.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage1dBufferRWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 67,
   FQN="clang::Type::isOCLImage1dBufferRWType", NM="_ZNK5clang4Type24isOCLImage1dBufferRWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type24isOCLImage1dBufferRWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage1dBufferRWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage1dBufferRW.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dRWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 68,
   FQN="clang::Type::isOCLImage2dRWType", NM="_ZNK5clang4Type18isOCLImage2dRWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type18isOCLImage2dRWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dRWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dRW.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayRWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 69,
   FQN="clang::Type::isOCLImage2dArrayRWType", NM="_ZNK5clang4Type23isOCLImage2dArrayRWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type23isOCLImage2dArrayRWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayRWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayRW.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dDepthRWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 70,
   FQN="clang::Type::isOCLImage2dDepthRWType", NM="_ZNK5clang4Type23isOCLImage2dDepthRWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type23isOCLImage2dDepthRWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dDepthRWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dDepthRW.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayDepthRWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 71,
   FQN="clang::Type::isOCLImage2dArrayDepthRWType", NM="_ZNK5clang4Type28isOCLImage2dArrayDepthRWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type28isOCLImage2dArrayDepthRWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayDepthRWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayDepthRW.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dMSAARWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 72,
   FQN="clang::Type::isOCLImage2dMSAARWType", NM="_ZNK5clang4Type22isOCLImage2dMSAARWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type22isOCLImage2dMSAARWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dMSAARWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dMSAARW.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayMSAARWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 73,
   FQN="clang::Type::isOCLImage2dArrayMSAARWType", NM="_ZNK5clang4Type27isOCLImage2dArrayMSAARWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type27isOCLImage2dArrayMSAARWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayMSAARWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayMSAARW.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dMSAADepthRWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 74,
   FQN="clang::Type::isOCLImage2dMSAADepthRWType", NM="_ZNK5clang4Type27isOCLImage2dMSAADepthRWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type27isOCLImage2dMSAADepthRWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dMSAADepthRWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dMSAADepthRW.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage2dArrayMSAADepthRWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 75,
   FQN="clang::Type::isOCLImage2dArrayMSAADepthRWType", NM="_ZNK5clang4Type32isOCLImage2dArrayMSAADepthRWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type32isOCLImage2dArrayMSAADepthRWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage2dArrayMSAADepthRWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage2dArrayMSAADepthRW.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOCLImage3dRWType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLImageTypes.def", line = 76,
   FQN="clang::Type::isOCLImage3dRWType", NM="_ZNK5clang4Type18isOCLImage3dRWTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type18isOCLImage3dRWTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOCLImage3dRWType() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLImage3dRW.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isImageType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5627,
   FQN="clang::Type::isImageType", NM="_ZNK5clang4Type11isImageTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type11isImageTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isImageType() /*const*/ {
    return isOCLImage1dROType()
       || isOCLImage1dArrayROType()
       || isOCLImage1dBufferROType()
       || isOCLImage2dROType()
       || isOCLImage2dArrayROType()
       || isOCLImage2dDepthROType()
       || isOCLImage2dArrayDepthROType()
       || isOCLImage2dMSAAROType()
       || isOCLImage2dArrayMSAAROType()
       || isOCLImage2dMSAADepthROType()
       || isOCLImage2dArrayMSAADepthROType()
       || isOCLImage3dROType()
       || isOCLImage1dWOType()
       || isOCLImage1dArrayWOType()
       || isOCLImage1dBufferWOType()
       || isOCLImage2dWOType()
       || isOCLImage2dArrayWOType()
       || isOCLImage2dDepthWOType()
       || isOCLImage2dArrayDepthWOType()
       || isOCLImage2dMSAAWOType()
       || isOCLImage2dArrayMSAAWOType()
       || isOCLImage2dMSAADepthWOType()
       || isOCLImage2dArrayMSAADepthWOType()
       || isOCLImage3dWOType()
       || isOCLImage1dRWType()
       || isOCLImage1dArrayRWType()
       || isOCLImage1dBufferRWType()
       || isOCLImage2dRWType()
       || isOCLImage2dArrayRWType()
       || isOCLImage2dDepthRWType()
       || isOCLImage2dArrayDepthRWType()
       || isOCLImage2dMSAARWType()
       || isOCLImage2dArrayMSAARWType()
       || isOCLImage2dMSAADepthRWType()
       || isOCLImage2dArrayMSAADepthRWType()
       || isOCLImage3dRWType()
       || false; // end boolean or operation
  }
 // Any OpenCL image type
  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isSamplerT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5603,
   FQN="clang::Type::isSamplerT", NM="_ZNK5clang4Type10isSamplerTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type10isSamplerTEv")
  //</editor-fold>
  public /*inline*/ boolean isSamplerT() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLSampler.getValue());
  }
 // OpenCL sampler_t
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isEventT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5607,
   FQN="clang::Type::isEventT", NM="_ZNK5clang4Type8isEventTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type8isEventTEv")
  //</editor-fold>
  public /*inline*/ boolean isEventT() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLEvent.getValue());
  }
 // OpenCL event_t
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isClkEventT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5611,
   FQN="clang::Type::isClkEventT", NM="_ZNK5clang4Type11isClkEventTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type11isClkEventTEv")
  //</editor-fold>
  public /*inline*/ boolean isClkEventT() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLClkEvent.getValue());
  }
 // OpenCL clk_event_t
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isQueueT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5615,
   FQN="clang::Type::isQueueT", NM="_ZNK5clang4Type8isQueueTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type8isQueueTEv")
  //</editor-fold>
  public /*inline*/ boolean isQueueT() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLQueue.getValue());
  }
 // OpenCL queue_t
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isNDRangeT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5619,
   FQN="clang::Type::isNDRangeT", NM="_ZNK5clang4Type10isNDRangeTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type10isNDRangeTEv")
  //</editor-fold>
  public /*inline*/ boolean isNDRangeT() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLNDRange.getValue());
  }
 // OpenCL ndrange_t
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isReserveIDT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5623,
   FQN="clang::Type::isReserveIDT", NM="_ZNK5clang4Type12isReserveIDTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type12isReserveIDTEv")
  //</editor-fold>
  public /*inline*/ boolean isReserveIDT() /*const*/ {
    return isSpecificBuiltinType(BuiltinType.Kind.OCLReserveID.getValue());
  }
 // OpenCL reserve_id_t
  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isPipeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5634,
   FQN="clang::Type::isPipeType", NM="_ZNK5clang4Type10isPipeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type10isPipeTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isPipeType() /*const*/ {
    return isa_PipeType(CanonicalType);
  }
 // OpenCL pipe type
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOpenCLSpecificType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5638,
   FQN="clang::Type::isOpenCLSpecificType", NM="_ZNK5clang4Type20isOpenCLSpecificTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type20isOpenCLSpecificTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOpenCLSpecificType() /*const*/ {
    return isSamplerT() || isEventT() || isImageType() || isClkEventT()
       || isQueueT() || isNDRangeT() || isReserveIDT() || isPipeType();
  }
 // Any OpenCL specific type
  
  /// Determines if this type, which must satisfy
  /// isObjCLifetimeType(), is implicitly __unsafe_unretained rather
  /// than implicitly __strong.
  // Any OpenCL specific type
  
  /// Determines if this type, which must satisfy
  /// isObjCLifetimeType(), is implicitly __unsafe_unretained rather
  /// than implicitly __strong.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isObjCARCImplicitlyUnretainedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3669,
   FQN="clang::Type::isObjCARCImplicitlyUnretainedType", NM="_ZNK5clang4Type33isObjCARCImplicitlyUnretainedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type33isObjCARCImplicitlyUnretainedTypeEv")
  //</editor-fold>
  public boolean isObjCARCImplicitlyUnretainedType() /*const*/ {
    assert (isObjCLifetimeType()) : "cannot query implicit lifetime for non-inferrable type";
    
    /*const*/ Type /*P*/ canon = getCanonicalTypeInternal().getTypePtr();
    {
      
      // Walk down to the base type.  We don't care about qualifiers for this.
      /*const*/ ArrayType /*P*/ array;
      while (((/*P*/ array = dyn_cast_ArrayType(canon)) != null)) {
        canon = array.getElementType().getTypePtr();
      }
    }
    {
      
      /*const*/ ObjCObjectPointerType /*P*/ opt = dyn_cast_ObjCObjectPointerType(canon);
      if ((opt != null)) {
        // Class and Class<Protocol> don't require retention.
        if (opt.getObjectType().isObjCClass()) {
          return true;
        }
      }
    }
    
    return false;
  }


  
  /// Return the implicit lifetime for this type, which must not be dependent.
  
  /// Return the implicit lifetime for this type, which must not be dependent.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getObjCARCImplicitLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3663,
   FQN="clang::Type::getObjCARCImplicitLifetime", NM="_ZNK5clang4Type26getObjCARCImplicitLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type26getObjCARCImplicitLifetimeEv")
  //</editor-fold>
  public Qualifiers.ObjCLifetime getObjCARCImplicitLifetime() /*const*/ {
    if (isObjCARCImplicitlyUnretainedType()) {
      return Qualifiers.ObjCLifetime.OCL_ExplicitNone;
    }
    return Qualifiers.ObjCLifetime.OCL_Strong;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::ScalarTypeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1758,
   FQN="clang::Type::ScalarTypeKind", NM="_ZN5clang4Type14ScalarTypeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Type14ScalarTypeKindE")
  //</editor-fold>
  public enum ScalarTypeKind implements Native.ComparableLower {
    STK_CPointer(0),
    STK_BlockPointer(STK_CPointer.getValue() + 1),
    STK_ObjCObjectPointer(STK_BlockPointer.getValue() + 1),
    STK_MemberPointer(STK_ObjCObjectPointer.getValue() + 1),
    STK_Bool(STK_MemberPointer.getValue() + 1),
    STK_Integral(STK_Bool.getValue() + 1),
    STK_Floating(STK_Integral.getValue() + 1),
    STK_IntegralComplex(STK_Floating.getValue() + 1),
    STK_FloatingComplex(STK_IntegralComplex.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ScalarTypeKind valueOf(int val) {
      ScalarTypeKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ScalarTypeKind[] VALUES;
      private static final ScalarTypeKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ScalarTypeKind kind : ScalarTypeKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ScalarTypeKind[min < 0 ? (1-min) : 0];
        VALUES = new ScalarTypeKind[max >= 0 ? (1+max) : 0];
        for (ScalarTypeKind kind : ScalarTypeKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ScalarTypeKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ScalarTypeKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ScalarTypeKind)obj).value);}
    //</editor-fold>
  };
  /// Given that this is a scalar type, classify it.
  /// Given that this is a scalar type, classify it.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getScalarTypeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1829,
   FQN="clang::Type::getScalarTypeKind", NM="_ZNK5clang4Type17getScalarTypeKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type17getScalarTypeKindEv")
  //</editor-fold>
  public Type.ScalarTypeKind getScalarTypeKind() /*const*/ {
    assert (isScalarType());
    
    /*const*/ Type /*P*/ T = CanonicalType.getTypePtr();
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(T);
      if ((BT != null)) {
        if (BT.getKind() == BuiltinType.Kind.Bool) {
          return ScalarTypeKind.STK_Bool;
        }
        if (BT.getKind() == BuiltinType.Kind.NullPtr) {
          return ScalarTypeKind.STK_CPointer;
        }
        if (BT.isInteger()) {
          return ScalarTypeKind.STK_Integral;
        }
        if (BT.isFloatingPoint()) {
          return ScalarTypeKind.STK_Floating;
        }
        throw new llvm_unreachable("unknown scalar builtin type");
      } else if (isa_PointerType(T)) {
        return ScalarTypeKind.STK_CPointer;
      } else if (isa_BlockPointerType(T)) {
        return ScalarTypeKind.STK_BlockPointer;
      } else if (isa_ObjCObjectPointerType(T)) {
        return ScalarTypeKind.STK_ObjCObjectPointer;
      } else if (isa_MemberPointerType(T)) {
        return ScalarTypeKind.STK_MemberPointer;
      } else if (isa_EnumType(T)) {
        assert (cast_EnumType(T).getDecl().isComplete());
        return ScalarTypeKind.STK_Integral;
      } else {
        /*const*/ ComplexType /*P*/ CT = dyn_cast_ComplexType(T);
        if ((CT != null)) {
          if (CT.getElementType().$arrow().isRealFloatingType()) {
            return ScalarTypeKind.STK_FloatingComplex;
          }
          return ScalarTypeKind.STK_IntegralComplex;
        }
      }
    }
    throw new llvm_unreachable("unknown scalar type");
  }


  
  /// Whether this type is a dependent type, meaning that its definition
  /// somehow depends on a template parameter (C++ [temp.dep.type]).
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isDependentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1774,
   FQN="clang::Type::isDependentType", NM="_ZNK5clang4Type15isDependentTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type15isDependentTypeEv")
  //</editor-fold>
  public boolean isDependentType() /*const*/ {
    return Unnamed_field.TypeBits.Dependent;
  }

  
  /// \brief Determine whether this type is an instantiation-dependent type,
  /// meaning that the type involves a template parameter (even if the
  /// definition does not actually depend on the type substituted for that
  /// template parameter).
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isInstantiationDependentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1780,
   FQN="clang::Type::isInstantiationDependentType", NM="_ZNK5clang4Type28isInstantiationDependentTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type28isInstantiationDependentTypeEv")
  //</editor-fold>
  public boolean isInstantiationDependentType() /*const*/ {
    return Unnamed_field.TypeBits.InstantiationDependent;
  }

  
  /// \brief Determine whether this type is an undeduced type, meaning that
  /// it somehow involves a C++11 'auto' type which has not yet been deduced.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isUndeducedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5749,
   FQN="clang::Type::isUndeducedType", NM="_ZNK5clang4Type15isUndeducedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type15isUndeducedTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isUndeducedType() /*const*/ {
    /*const*/ AutoType /*P*/ AT = getContainedAutoType();
    return (AT != null) && !AT.isDeduced();
  }

  
  /// \brief Whether this type is a variably-modified type (C99 6.7.5).
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isVariablyModifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1789,
   FQN="clang::Type::isVariablyModifiedType", NM="_ZNK5clang4Type22isVariablyModifiedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type22isVariablyModifiedTypeEv")
  //</editor-fold>
  public boolean isVariablyModifiedType() /*const*/ {
    return Unnamed_field.TypeBits.VariablyModified;
  }

  
  /// \brief Whether this type involves a variable-length array type
  /// with a definite size.
  
  /// \brief Whether this type involves a variable-length array type
  /// with a definite size.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::hasSizedVLAType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3741,
   FQN="clang::Type::hasSizedVLAType", NM="_ZNK5clang4Type15hasSizedVLATypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type15hasSizedVLATypeEv")
  //</editor-fold>
  public boolean hasSizedVLAType() /*const*/ {
    if (!isVariablyModifiedType()) {
      return false;
    }
    {
      
      /*const*/ PointerType /*P*/ ptr = getAs(PointerType.class);
      if ((ptr != null)) {
        return ptr.getPointeeType().$arrow().hasSizedVLAType();
      }
    }
    {
      /*const*/ ReferenceType /*P*/ ref = getAs(ReferenceType.class);
      if ((ref != null)) {
        return ref.getPointeeType().$arrow().hasSizedVLAType();
      }
    }
    {
      /*const*/ ArrayType /*P*/ arr = getAsArrayTypeUnsafe();
      if ((arr != null)) {
        if (isa_VariableArrayType(arr)
           && (cast_VariableArrayType(arr).getSizeExpr() != null)) {
          return true;
        }
        
        return arr.getElementType().$arrow().hasSizedVLAType();
      }
    }
    
    return false;
  }


  
  /// \brief Whether this type is or contains a local or unnamed type.
  
  /// \brief Whether this type is or contains a local or unnamed type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::hasUnnamedOrLocalType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3381,
   FQN="clang::Type::hasUnnamedOrLocalType", NM="_ZNK5clang4Type21hasUnnamedOrLocalTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type21hasUnnamedOrLocalTypeEv")
  //</editor-fold>
  public boolean hasUnnamedOrLocalType() /*const*/ {
    TypePropertyCache.$for(Private.class).ensure(this);
    return Unnamed_field.TypeBits.hasLocalOrUnnamedType();
  }


  
  
  /// \brief Determines whether this is a type for which one can define
  /// an overloaded operator.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isOverloadableType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5756,
   FQN="clang::Type::isOverloadableType", NM="_ZNK5clang4Type18isOverloadableTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type18isOverloadableTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isOverloadableType() /*const*/ {
    return isDependentType() || isRecordType() || isEnumeralType();
  }

  
  /// \brief Determine wither this type is a C++ elaborated-type-specifier.
  
  /// \brief Determine wither this type is a C++ elaborated-type-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isElaboratedTypeSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2494,
   FQN="clang::Type::isElaboratedTypeSpecifier", NM="_ZNK5clang4Type25isElaboratedTypeSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type25isElaboratedTypeSpecifierEv")
  //</editor-fold>
  public boolean isElaboratedTypeSpecifier() /*const*/ {
    ElaboratedTypeKeyword Keyword;
    {
      /*const*/ ElaboratedType /*P*/ Elab = dyn_cast_ElaboratedType(this);
      if ((Elab != null)) {
        Keyword = Elab.getKeyword();
      } else {
        /*const*/ DependentNameType /*P*/ DepName = dyn_cast_DependentNameType(this);
        if ((DepName != null)) {
          Keyword = DepName.getKeyword();
        } else {
          /*const*/ DependentTemplateSpecializationType /*P*/ DepTST = dyn_cast_DependentTemplateSpecializationType(this);
          if ((DepTST != null)) {
            Keyword = DepTST.getKeyword();
          } else {
            return false;
          }
        }
      }
    }
    
    return TypeWithKeyword.KeywordIsTagTypeKind(Keyword);
  }


  
  
  /// \brief Determines whether this type can decay to a pointer type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::canDecayToPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5761,
   FQN="clang::Type::canDecayToPointerType", NM="_ZNK5clang4Type21canDecayToPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type21canDecayToPointerTypeEv")
  //</editor-fold>
  public /*inline*/ boolean canDecayToPointerType() /*const*/ {
    return isFunctionType() || isArrayType();
  }

  
  /// Whether this type is represented natively as a pointer.  This includes
  /// pointers, references, block pointers, and Objective-C interface,
  /// qualified id, and qualified interface types, as well as nullptr_t.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::hasPointerRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5765,
   FQN="clang::Type::hasPointerRepresentation", NM="_ZNK5clang4Type24hasPointerRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type24hasPointerRepresentationEv")
  //</editor-fold>
  public /*inline*/ boolean hasPointerRepresentation() /*const*/ {
    return (isPointerType() || isReferenceType() || isBlockPointerType()
       || isObjCObjectPointerType() || isNullPtrType());
  }

  
  /// Whether this type can represent an objective pointer type for the
  /// purpose of GC'ability
  //<editor-fold defaultstate="collapsed" desc="clang::Type::hasObjCPointerRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5770,
   FQN="clang::Type::hasObjCPointerRepresentation", NM="_ZNK5clang4Type28hasObjCPointerRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type28hasObjCPointerRepresentationEv")
  //</editor-fold>
  public /*inline*/ boolean hasObjCPointerRepresentation() /*const*/ {
    return isObjCObjectPointerType();
  }

  
  /// \brief Determine whether this type has an integer representation
  /// of some sort, e.g., it is an integer type or a vector.
  
  /// \brief Determine whether this type has an integer representation
  /// of some sort, e.g., it is an integer type or a vector.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::hasIntegerRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1599,
   FQN="clang::Type::hasIntegerRepresentation", NM="_ZNK5clang4Type24hasIntegerRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type24hasIntegerRepresentationEv")
  //</editor-fold>
  public boolean hasIntegerRepresentation() /*const*/ {
    {
      /*const*/ VectorType /*P*/ VT = dyn_cast_VectorType(CanonicalType);
      if ((VT != null)) {
        return VT.getElementType().$arrow().isIntegerType();
      } else {
        return isIntegerType();
      }
    }
  }


  
  /// \brief Determine whether this type has an signed integer representation
  /// of some sort, e.g., it is an signed integer type or a vector.
  
  /// \brief Determine whether this type has an signed integer representation
  /// of some sort, e.g., it is an signed integer type or a vector.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::hasSignedIntegerRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1736,
   FQN="clang::Type::hasSignedIntegerRepresentation", NM="_ZNK5clang4Type30hasSignedIntegerRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type30hasSignedIntegerRepresentationEv")
  //</editor-fold>
  public boolean hasSignedIntegerRepresentation() /*const*/ {
    {
      /*const*/ VectorType /*P*/ VT = dyn_cast_VectorType(CanonicalType);
      if ((VT != null)) {
        return VT.getElementType().$arrow().isSignedIntegerOrEnumerationType();
      } else {
        return isSignedIntegerOrEnumerationType();
      }
    }
  }


  
  /// \brief Determine whether this type has an unsigned integer representation
  /// of some sort, e.g., it is an unsigned integer type or a vector.
  
  /// \brief Determine whether this type has an unsigned integer representation
  /// of some sort, e.g., it is an unsigned integer type or a vector.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::hasUnsignedIntegerRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1776,
   FQN="clang::Type::hasUnsignedIntegerRepresentation", NM="_ZNK5clang4Type32hasUnsignedIntegerRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type32hasUnsignedIntegerRepresentationEv")
  //</editor-fold>
  public boolean hasUnsignedIntegerRepresentation() /*const*/ {
    {
      /*const*/ VectorType /*P*/ VT = dyn_cast_VectorType(CanonicalType);
      if ((VT != null)) {
        return VT.getElementType().$arrow().isUnsignedIntegerOrEnumerationType();
      } else {
        return isUnsignedIntegerOrEnumerationType();
      }
    }
  }


  
  /// \brief Determine whether this type has a floating-point representation
  /// of some sort, e.g., it is a floating-point type or a vector thereof.
  
  /// \brief Determine whether this type has a floating-point representation
  /// of some sort, e.g., it is a floating-point type or a vector thereof.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::hasFloatingRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1792,
   FQN="clang::Type::hasFloatingRepresentation", NM="_ZNK5clang4Type25hasFloatingRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type25hasFloatingRepresentationEv")
  //</editor-fold>
  public boolean hasFloatingRepresentation() /*const*/ {
    {
      /*const*/ VectorType /*P*/ VT = dyn_cast_VectorType(CanonicalType);
      if ((VT != null)) {
        return VT.getElementType().$arrow().isFloatingType();
      } else {
        return isFloatingType();
      }
    }
  }


  
  // Type Checking Functions: Check to see if this type is structurally the
  // specified type, ignoring typedefs and qualifiers, and return a pointer to
  // the best type we can.
  
  // Type Checking Functions: Check to see if this type is structurally the
  // specified type, ignoring typedefs and qualifiers, and return a pointer to
  // the best type we can.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsStructureType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 431,
   FQN="clang::Type::getAsStructureType", NM="_ZNK5clang4Type18getAsStructureTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type18getAsStructureTypeEv")
  //</editor-fold>
  public /*const*/ RecordType /*P*/ getAsStructureType() /*const*/ {
    {
      // If this is directly a structure type, return it.
      /*const*/ RecordType /*P*/ RT = dyn_cast_RecordType(this);
      if ((RT != null)) {
        if (RT.getDecl().isStruct()) {
          return RT;
        }
      }
    }
    {
      
      // If the canonical form of this type isn't the right kind, reject it.
      /*const*/ RecordType /*P*/ RT = dyn_cast_RecordType(CanonicalType);
      if ((RT != null)) {
        if (!RT.getDecl().isStruct()) {
          return null;
        }
        
        // If this is a typedef for a structure type, strip the typedef off without
        // losing all typedef information.
        return cast_RecordType(getUnqualifiedDesugaredType());
      }
    }
    return null;
  }


  /// NOTE: getAs*ArrayType are methods on ASTContext.
  /// NOTE: getAs*ArrayType are methods on ASTContext.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsUnionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 450,
   FQN="clang::Type::getAsUnionType", NM="_ZNK5clang4Type14getAsUnionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type14getAsUnionTypeEv")
  //</editor-fold>
  public /*const*/ RecordType /*P*/ getAsUnionType() /*const*/ {
    {
      // If this is directly a union type, return it.
      /*const*/ RecordType /*P*/ RT = dyn_cast_RecordType(this);
      if ((RT != null)) {
        if (RT.getDecl().isUnion()) {
          return RT;
        }
      }
    }
    {
      
      // If the canonical form of this type isn't the right kind, reject it.
      /*const*/ RecordType /*P*/ RT = dyn_cast_RecordType(CanonicalType);
      if ((RT != null)) {
        if (!RT.getDecl().isUnion()) {
          return null;
        }
        
        // If this is a typedef for a union type, strip the typedef off without
        // losing all typedef information.
        return cast_RecordType(getUnqualifiedDesugaredType());
      }
    }
    
    return null;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsComplexIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 408,
   FQN="clang::Type::getAsComplexIntegerType", NM="_ZNK5clang4Type23getAsComplexIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type23getAsComplexIntegerTypeEv")
  //</editor-fold>
  public /*const*/ ComplexType /*P*/ getAsComplexIntegerType() /*const*/ {
    {
      /*const*/ ComplexType /*P*/ Complex = getAs(ComplexType.class);
      if ((Complex != null)) {
        if (Complex.getElementType().$arrow().isIntegerType()) {
          return Complex;
        }
      }
    }
    return null;
  }
 // GCC complex int type.

  // GCC complex int type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsObjCInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1498,
   FQN="clang::Type::getAsObjCInterfaceType", NM="_ZNK5clang4Type22getAsObjCInterfaceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type22getAsObjCInterfaceTypeEv")
  //</editor-fold>
  public /*const*/ ObjCObjectType /*P*/ getAsObjCInterfaceType() /*const*/ {
    {
      /*const*/ ObjCObjectType /*P*/ OT = getAs(ObjCObjectType.class);
      if ((OT != null)) {
        if ((OT.getInterface() != null)) {
          return OT;
        }
      }
    }
    return null;
  }


  // The following is a convenience method that returns an ObjCObjectPointerType
  // for object declared using an interface.
  // The following is a convenience method that returns an ObjCObjectPointerType
  // for object declared using an interface.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsObjCInterfacePointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1505,
   FQN="clang::Type::getAsObjCInterfacePointerType", NM="_ZNK5clang4Type29getAsObjCInterfacePointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type29getAsObjCInterfacePointerTypeEv")
  //</editor-fold>
  public /*const*/ ObjCObjectPointerType /*P*/ getAsObjCInterfacePointerType() /*const*/ {
    {
      /*const*/ ObjCObjectPointerType /*P*/ OPT = getAs(ObjCObjectPointerType.class);
      if ((OPT != null)) {
        if ((OPT.getInterfaceType() != null)) {
          return OPT;
        }
      }
    }
    return null;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsObjCQualifiedIdType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1478,
   FQN="clang::Type::getAsObjCQualifiedIdType", NM="_ZNK5clang4Type24getAsObjCQualifiedIdTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type24getAsObjCQualifiedIdTypeEv")
  //</editor-fold>
  public /*const*/ ObjCObjectPointerType /*P*/ getAsObjCQualifiedIdType() /*const*/ {
    {
      // There is no sugar for ObjCQualifiedIdType's, just return the canonical
      // type pointer if it is the right class.
      /*const*/ ObjCObjectPointerType /*P*/ OPT = getAs(ObjCObjectPointerType.class);
      if ((OPT != null)) {
        if (OPT.isObjCQualifiedIdType()) {
          return OPT;
        }
      }
    }
    return null;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsObjCQualifiedClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1488,
   FQN="clang::Type::getAsObjCQualifiedClassType", NM="_ZNK5clang4Type27getAsObjCQualifiedClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type27getAsObjCQualifiedClassTypeEv")
  //</editor-fold>
  public /*const*/ ObjCObjectPointerType /*P*/ getAsObjCQualifiedClassType() /*const*/ {
    {
      // There is no sugar for ObjCQualifiedClassType's, just return the canonical
      // type pointer if it is the right class.
      /*const*/ ObjCObjectPointerType /*P*/ OPT = getAs(ObjCObjectPointerType.class);
      if ((OPT != null)) {
        if (OPT.isObjCQualifiedClassType()) {
          return OPT;
        }
      }
    }
    return null;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsObjCQualifiedInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1464,
   FQN="clang::Type::getAsObjCQualifiedInterfaceType", NM="_ZNK5clang4Type31getAsObjCQualifiedInterfaceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type31getAsObjCQualifiedInterfaceTypeEv")
  //</editor-fold>
  public /*const*/ ObjCObjectType /*P*/ getAsObjCQualifiedInterfaceType() /*const*/ {
    {
      // There is no sugar for ObjCObjectType's, just return the canonical
      // type pointer if it is the right class.  There is no typedef information to
      // return and these cannot be Address-space qualified.
      /*const*/ ObjCObjectType /*P*/ T = getAs(ObjCObjectType.class);
      if ((T != null)) {
        if ((T.getNumProtocols() != 0) && (T.getInterface() != null)) {
          return T;
        }
      }
    }
    return null;
  }


  
  /// \brief Retrieves the CXXRecordDecl that this type refers to, either
  /// because the type is a RecordType or because it is the injected-class-name
  /// type of a class template or class template partial specialization.
  
  /// \brief Retrieves the CXXRecordDecl that this type refers to, either
  /// because the type is a RecordType or because it is the injected-class-name
  /// type of a class template or class template partial specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsCXXRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1528,
   FQN="clang::Type::getAsCXXRecordDecl", NM="_ZNK5clang4Type18getAsCXXRecordDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type18getAsCXXRecordDeclEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getAsCXXRecordDecl() /*const*/ {
    return dyn_cast_or_null_CXXRecordDecl(getAsTagDecl());
  }


  
  /// \brief Retrieves the TagDecl that this type refers to, either
  /// because the type is a TagType or because it is the injected-class-name
  /// type of a class template or class template partial specialization.
  
  /// \brief Retrieves the TagDecl that this type refers to, either
  /// because the type is a TagType or because it is the injected-class-name
  /// type of a class template or class template partial specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsTagDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1532,
   FQN="clang::Type::getAsTagDecl", NM="_ZNK5clang4Type12getAsTagDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type12getAsTagDeclEv")
  //</editor-fold>
  public TagDecl /*P*/ getAsTagDecl() /*const*/ {
    {
      /*const*/ TagType /*P*/ TT = getAs(TagType.class);
      if ((TT != null)) {
        return cast_TagDecl(TT.getDecl());
      }
    }
    {
      /*const*/ InjectedClassNameType /*P*/ Injected = getAs$InjectedClassNameType();
      if ((Injected != null)) {
        return Injected.getDecl();
      }
    }
    
    return null;
  }


  
  /// If this is a pointer or reference to a RecordType, return the
  /// CXXRecordDecl that that type refers to.
  ///
  /// If this is not a pointer or reference, or the type being pointed to does
  /// not refer to a CXXRecordDecl, returns NULL.
  
  /// If this is a pointer or reference to a RecordType, return the
  /// CXXRecordDecl that that type refers to.
  ///
  /// If this is not a pointer or reference, or the type being pointed to does
  /// not refer to a CXXRecordDecl, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getPointeeCXXRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1513,
   FQN="clang::Type::getPointeeCXXRecordDecl", NM="_ZNK5clang4Type23getPointeeCXXRecordDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type23getPointeeCXXRecordDeclEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getPointeeCXXRecordDecl() /*const*/ {
    QualType PointeeType/*J*/= new QualType();
    {
      /*const*/ PointerType /*P*/ PT = getAs(PointerType.class);
      if ((PT != null)) {
        PointeeType.$assignMove(PT.getPointeeType());
      } else {
        /*const*/ ReferenceType /*P*/ RT = getAs(ReferenceType.class);
        if ((RT != null)) {
          PointeeType.$assignMove(RT.getPointeeType());
        } else {
          return null;
        }
      }
    }
    {
      
      /*const*/ RecordType /*P*/ RT = PointeeType.$arrow().<RecordType>getAs$RecordType();
      if ((RT != null)) {
        return dyn_cast_CXXRecordDecl(RT.getDecl());
      }
    }
    
    return null;
  }


  
  /// Get the AutoType whose type will be deduced for a variable with
  /// an initializer of this type. This looks through declarators like pointer
  /// types, but not through decltype or typedefs.
  
  /// Get the AutoType whose type will be deduced for a variable with
  /// an initializer of this type. This looks through declarators like pointer
  /// types, but not through decltype or typedefs.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getContainedAutoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1595,
   FQN="clang::Type::getContainedAutoType", NM="_ZNK5clang4Type20getContainedAutoTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type20getContainedAutoTypeEv")
  //</editor-fold>
  public AutoType /*P*/ getContainedAutoType() /*const*/ {
    return new GetContainedAutoVisitor().Visit(this);
  }


  
  /// Member-template getAs<specific type>'.  Look through sugar for
  /// an instance of \<specific type>.   This scheme will eventually
  /// replace the specific getAsXXXX methods above.
  ///
  /// There are some specializations of this member template listed
  /// immediately following this class.
  /*template <typename T> TEMPLATE*/
  
  // Member-template getAs<specific type>'.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*class param and assert*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5818,
   FQN="clang::Type::getAs", NM="Tpl__ZNK5clang4Type5getAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZNK5clang4Type5getAsEv")
  //</editor-fold>
  public </*typename*/ T> /*const*/ T /*P*/ getAs(Class<T> clazz) /*const*/ {
    assert !ArrayType.class.isAssignableFrom(clazz) : "ArrayType cannot_be_used_with_getAs " + clazz;
    ArrayType_cannot_be_used_with_getAs<T> at; 
    ///*J:(void)*/at;
    {
      
      // If this is directly a T type, return it.
      /*const*/ T /*P*/ Ty = dyn_cast(clazz, this);
      if (Ty != null) {
        return Ty;
      }
    }
    
    // If the canonical form of this type isn't the right kind, reject it.
    if (!isa(clazz, CanonicalType)) {
      return null;
    }
    
    // If this is a typedef for the type, strip the typedef off without
    // losing all typedef information.
    return cast(clazz, getUnqualifiedDesugaredType());
  }

  
  /// A variant of getAs<> for array types which silently discards
  /// qualifiers from the outermost type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAsArrayTypeUnsafe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5835,
   FQN="clang::Type::getAsArrayTypeUnsafe", NM="_ZNK5clang4Type20getAsArrayTypeUnsafeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type20getAsArrayTypeUnsafeEv")
  //</editor-fold>
  public /*inline*/ /*const*/ ArrayType /*P*/ getAsArrayTypeUnsafe() /*const*/ {
    {
      // If this is directly an array type, return it.
      /*const*/ ArrayType /*P*/ arr = dyn_cast_ArrayType(this);
      if ((arr != null)) {
        return arr;
      }
    }
    
    // If the canonical form of this type isn't the right kind, reject it.
    if (!isa_ArrayType(CanonicalType)) {
      return null;
    }
    
    // If this is a typedef for the type, strip the typedef off without
    // losing all typedef information.
    return cast_ArrayType(getUnqualifiedDesugaredType());
  }

  
  /// Member-template castAs<specific type>.  Look through sugar for
  /// the underlying instance of \<specific type>.
  ///
  /// This method has the same relationship to getAs<T> as cast<T> has
  /// to dyn_cast<T>; which is to say, the underlying type *must*
  /// have the intended type, and this method will never return null.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Type::castAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*class param and assert*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5849,
   FQN="clang::Type::castAs", NM="Tpl__ZNK5clang4Type6castAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZNK5clang4Type6castAsEv")
  //</editor-fold>
  public </*typename*/ T> /*const*/ T /*P*/ castAs(Class<T> clazz) /*const*/ {
    assert !ArrayType.class.isAssignableFrom(clazz) : "ArrayType cannot_be_used_with_getAs " + clazz;
    ArrayType_cannot_be_used_with_getAs<T> at;
    ///*J:(void)*/at;
    {
      
      /*const*/ T /*P*/ ty = dyn_cast(clazz, this);
      if (ty != null) {
        return ty;
      }
    }
    assert Native.$bool(isa(clazz, CanonicalType));
    return cast(clazz, getUnqualifiedDesugaredType());
  }

  
  /// A variant of castAs<> for array type which silently discards
  /// qualifiers from the outermost type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::castAsArrayTypeUnsafe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5858,
   FQN="clang::Type::castAsArrayTypeUnsafe", NM="_ZNK5clang4Type21castAsArrayTypeUnsafeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type21castAsArrayTypeUnsafeEv")
  //</editor-fold>
  public /*inline*/ /*const*/ ArrayType /*P*/ castAsArrayTypeUnsafe() /*const*/ {
    assert (isa_ArrayType(CanonicalType));
    {
      /*const*/ ArrayType /*P*/ arr = dyn_cast_ArrayType(this);
      if ((arr != null)) {
        return arr;
      }
    }
    return cast_ArrayType(getUnqualifiedDesugaredType());
  }

  
  /// Get the base element type of this type, potentially discarding type
  /// qualifiers.  This should never be used when type qualifiers
  /// are meaningful.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getBaseElementTypeUnsafe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5774,
   FQN="clang::Type::getBaseElementTypeUnsafe", NM="_ZNK5clang4Type24getBaseElementTypeUnsafeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type24getBaseElementTypeUnsafeEv")
  //</editor-fold>
  public /*inline*/ /*const*/ Type /*P*/ getBaseElementTypeUnsafe() /*const*/ {
    /*const*/ Type /*P*/ type = this;
    {
      /*const*/ ArrayType /*P*/ arrayType;
      while (((/*P*/ arrayType = type.getAsArrayTypeUnsafe()) != null)) {
        type = arrayType.getElementType().getTypePtr();
      }
    }
    return type;
  }

  
  /// If this is an array type, return the element type of the array,
  /// potentially with type qualifiers missing.
  /// This should never be used when type qualifiers are meaningful.
  
  /// If this is an array type, return the element type of the array,
  /// potentially with type qualifiers missing.
  /// This should never be used when type qualifiers are meaningful.
  
  /// getArrayElementTypeNoTypeQual - If this is an array type, return the
  /// element type of the array, potentially with type qualifiers missing.
  /// This method should never be used when type qualifiers are meaningful.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getArrayElementTypeNoTypeQual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 191,
   FQN="clang::Type::getArrayElementTypeNoTypeQual", NM="_ZNK5clang4Type29getArrayElementTypeNoTypeQualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type29getArrayElementTypeNoTypeQualEv")
  //</editor-fold>
  public /*const*/ Type /*P*/ getArrayElementTypeNoTypeQual() /*const*/ {
    {
      // If this is directly an array type, return it.
      /*const*/ ArrayType /*P*/ ATy = dyn_cast_ArrayType(this);
      if ((ATy != null)) {
        return ATy.getElementType().getTypePtr();
      }
    }
    
    // If the canonical form of this type isn't the right kind, reject it.
    if (!isa_ArrayType(CanonicalType)) {
      return null;
    }
    
    // If this is a typedef for an array type, strip the typedef off without
    // losing all typedef information.
    return cast_ArrayType(getUnqualifiedDesugaredType()).
        getElementType().getTypePtr();
  }


  
  /// If this is a pointer type, return the pointee type.
  /// If this is an array type, return the array element type.
  /// This should never be used when type qualifiers are meaningful.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getPointeeOrArrayElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5781,
   FQN="clang::Type::getPointeeOrArrayElementType", NM="_ZNK5clang4Type28getPointeeOrArrayElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type28getPointeeOrArrayElementTypeEv")
  //</editor-fold>
  public /*inline*/ /*const*/ Type /*P*/ getPointeeOrArrayElementType() /*const*/ {
    /*const*/ Type /*P*/ type = this;
    if (type.isAnyPointerType()) {
      return type.getPointeeType().getTypePtr();
    } else if (type.isArrayType()) {
      return type.getBaseElementTypeUnsafe();
    }
    return type;
  }

  
  /// If this is a pointer, ObjC object pointer, or block
  /// pointer, this returns the respective pointee.
  
  /// If this is a pointer, ObjC object pointer, or block
  /// pointer, this returns the respective pointee.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getPointeeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 415,
   FQN="clang::Type::getPointeeType", NM="_ZNK5clang4Type14getPointeeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type14getPointeeTypeEv")
  //</editor-fold>
  public QualType getPointeeType() /*const*/ {
    {
      /*const*/ PointerType /*P*/ PT = getAs(PointerType.class);
      if ((PT != null)) {
        return PT.getPointeeType();
      }
    }
    {
      /*const*/ ObjCObjectPointerType /*P*/ OPT = getAs(ObjCObjectPointerType.class);
      if ((OPT != null)) {
        return OPT.getPointeeType();
      }
    }
    {
      /*const*/ BlockPointerType /*P*/ BPT = getAs(BlockPointerType.class);
      if ((BPT != null)) {
        return BPT.getPointeeType();
      }
    }
    {
      /*const*/ ReferenceType /*P*/ RT = getAs(ReferenceType.class);
      if ((RT != null)) {
        return RT.getPointeeType();
      }
    }
    {
      /*const*/ MemberPointerType /*P*/ MPT = getAs(MemberPointerType.class);
      if ((MPT != null)) {
        return MPT.getPointeeType();
      }
    }
    {
      /*const*/ DecayedType /*P*/ DT = getAs(DecayedType.class);
      if ((DT != null)) {
        return DT.getPointeeType();
      }
    }
    return new QualType();
  }


  
  /// Return the specified type with any "sugar" removed from the type,
  /// removing any typedefs, typeofs, etc., as well as any qualifiers.
  
  /// Return the specified type with any "sugar" removed from the type,
  /// removing any typedefs, typeofs, etc., as well as any qualifiers.
  
  /// getUnqualifiedDesugaredType - Pull any qualifiers and syntactic
  /// sugar off the given type.  This should produce an object of the
  /// same dynamic type as the canonical type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getUnqualifiedDesugaredType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 341,
   FQN="clang::Type::getUnqualifiedDesugaredType", NM="_ZNK5clang4Type27getUnqualifiedDesugaredTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type27getUnqualifiedDesugaredTypeEv")
  //</editor-fold>
  public /*const*/ Type /*P*/ getUnqualifiedDesugaredType() /*const*/ {
    /*const*/ Type /*P*/ Cur = this;
    while (true) {
      switch (Cur.getTypeClass()) {
       case Builtin:
        {
          /*const*/ BuiltinType /*P*/ Ty = cast_BuiltinType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Complex:
        {
          /*const*/ ComplexType /*P*/ Ty = cast_ComplexType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Pointer:
        {
          /*const*/ PointerType /*P*/ Ty = cast_PointerType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case BlockPointer:
        {
          /*const*/ BlockPointerType /*P*/ Ty = cast_BlockPointerType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case LValueReference:
        {
          /*const*/ LValueReferenceType /*P*/ Ty = cast_LValueReferenceType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case RValueReference:
        {
          /*const*/ RValueReferenceType /*P*/ Ty = cast_RValueReferenceType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case MemberPointer:
        {
          /*const*/ MemberPointerType /*P*/ Ty = cast_MemberPointerType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case ConstantArray:
        {
          /*const*/ ConstantArrayType /*P*/ Ty = cast_ConstantArrayType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case IncompleteArray:
        {
          /*const*/ IncompleteArrayType /*P*/ Ty = cast_IncompleteArrayType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case VariableArray:
        {
          /*const*/ VariableArrayType /*P*/ Ty = cast_VariableArrayType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case DependentSizedArray:
        {
          /*const*/ DependentSizedArrayType /*P*/ Ty = cast_DependentSizedArrayType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case DependentSizedExtVector:
        {
          /*const*/ DependentSizedExtVectorType /*P*/ Ty = cast_DependentSizedExtVectorType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Vector:
        {
          /*const*/ VectorType /*P*/ Ty = cast_VectorType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case ExtVector:
        {
          /*const*/ ExtVectorType /*P*/ Ty = cast_ExtVectorType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case FunctionProto:
        {
          /*const*/ FunctionProtoType /*P*/ Ty = cast_FunctionProtoType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case FunctionNoProto:
        {
          /*const*/ FunctionNoProtoType /*P*/ Ty = cast_FunctionNoProtoType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case UnresolvedUsing:
        {
          /*const*/ UnresolvedUsingType /*P*/ Ty = cast_UnresolvedUsingType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Paren:
        {
          /*const*/ ParenType /*P*/ Ty = cast_ParenType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Typedef:
        {
          /*const*/ TypedefType /*P*/ Ty = cast_TypedefType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Adjusted:
        {
          /*const*/ AdjustedType /*P*/ Ty = cast_AdjustedType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Decayed:
        {
          /*const*/ DecayedType /*P*/ Ty = cast_DecayedType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case TypeOfExpr:
        {
          /*const*/ TypeOfExprType /*P*/ Ty = cast_TypeOfExprType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case TypeOf:
        {
          /*const*/ TypeOfType /*P*/ Ty = cast_TypeOfType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Decltype:
        {
          /*const*/ DecltypeType /*P*/ Ty = cast_DecltypeType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case UnaryTransform:
        {
          /*const*/ UnaryTransformType /*P*/ Ty = cast_UnaryTransformType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Record:
        {
          /*const*/ RecordType /*P*/ Ty = cast_RecordType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Enum:
        {
          /*const*/ EnumType /*P*/ Ty = cast_EnumType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Elaborated:
        {
          /*const*/ ElaboratedType /*P*/ Ty = cast_ElaboratedType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Attributed:
        {
          /*const*/ AttributedType /*P*/ Ty = cast_AttributedType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case TemplateTypeParm:
        {
          /*const*/ TemplateTypeParmType /*P*/ Ty = cast_TemplateTypeParmType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case SubstTemplateTypeParm:
        {
          /*const*/ SubstTemplateTypeParmType /*P*/ Ty = cast_SubstTemplateTypeParmType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case SubstTemplateTypeParmPack:
        {
          /*const*/ SubstTemplateTypeParmPackType /*P*/ Ty = cast_SubstTemplateTypeParmPackType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case TemplateSpecialization:
        {
          /*const*/ TemplateSpecializationType /*P*/ Ty = cast_TemplateSpecializationType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Auto:
        {
          /*const*/ AutoType /*P*/ Ty = cast_AutoType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case InjectedClassName:
        {
          /*const*/ InjectedClassNameType /*P*/ Ty = cast_InjectedClassNameType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case DependentName:
        {
          /*const*/ DependentNameType /*P*/ Ty = cast_DependentNameType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case DependentTemplateSpecialization:
        {
          /*const*/ DependentTemplateSpecializationType /*P*/ Ty = cast_DependentTemplateSpecializationType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case PackExpansion:
        {
          /*const*/ PackExpansionType /*P*/ Ty = cast_PackExpansionType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case ObjCObject:
        {
          /*const*/ ObjCObjectType /*P*/ Ty = cast_ObjCObjectType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case ObjCInterface:
        {
          /*const*/ ObjCInterfaceType /*P*/ Ty = cast_ObjCInterfaceType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case ObjCObjectPointer:
        {
          /*const*/ ObjCObjectPointerType /*P*/ Ty = cast_ObjCObjectPointerType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Pipe:
        {
          /*const*/ PipeType /*P*/ Ty = cast_PipeType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
       case Atomic:
        {
          /*const*/ AtomicType /*P*/ Ty = cast_AtomicType(Cur);
          if (!Ty.isSugared()) {
            return Cur;
          }
          Cur = Ty.desugar().getTypePtr();
          break;
        }
      }
    }
  }


  
  /// More type predicates useful for type checking/promotion
  
  /// More type predicates useful for type checking/promotion
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isPromotableIntegerType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2320,
   FQN="clang::Type::isPromotableIntegerType", NM="_ZNK5clang4Type23isPromotableIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type23isPromotableIntegerTypeEv")
  //</editor-fold>
  public boolean isPromotableIntegerType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = getAs$BuiltinType();
      if ((BT != null)) {
        switch (BT.getKind()) {
         case Bool:
         case Char_S:
         case Char_U:
         case SChar:
         case UChar:
         case Short:
         case UShort:
         case WChar_S:
         case WChar_U:
         case Char16:
         case Char32:
          return true;
         default:
          return false;
        }
      }
    }
    {
      
      // Enumerated types are promotable to their compatible integer types
      // (C99 6.3.1.1) a.k.a. its underlying type (C++ [conv.prom]p2).
      /*const*/ EnumType /*P*/ ET = getAs$EnumType();
      if ((ET != null)) {
        if (this.isDependentType() || ET.getDecl().getPromotionType().isNull()
           || ET.getDecl().isScoped()) {
          return false;
        }
        
        return true;
      }
    }
    
    return false;
  }
 // C99 6.3.1.1p2

  
  /// Return true if this is an integer type that is
  /// signed, according to C99 6.2.5p4 [char, signed char, short, int, long..],
  /// or an enum decl which has a signed representation.
  // C99 6.3.1.1p2
  
  /// Return true if this is an integer type that is
  /// signed, according to C99 6.2.5p4 [char, signed char, short, int, long..],
  /// or an enum decl which has a signed representation.
  
  /// isSignedIntegerType - Return true if this is an integer type that is
  /// signed, according to C99 6.2.5p4 [char, signed char, short, int, long..],
  /// an enum decl which has a signed representation
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isSignedIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1706,
   FQN="clang::Type::isSignedIntegerType", NM="_ZNK5clang4Type19isSignedIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type19isSignedIntegerTypeEv")
  //</editor-fold>
  public boolean isSignedIntegerType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() >= BuiltinType.Kind.Char_S.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.Int128.getValue();
      }
    }
    {
      
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(CanonicalType);
      if ((ET != null)) {
        // Incomplete enum types are not treated as integer types.
        // FIXME: In C++, enum types are never integer types.
        if (ET.getDecl().isComplete() && !ET.getDecl().isScoped()) {
          return ET.getDecl().getIntegerType().$arrow().isSignedIntegerType();
        }
      }
    }
    
    return false;
  }


  
  /// Return true if this is an integer type that is
  /// unsigned, according to C99 6.2.5p6 [which returns true for _Bool],
  /// or an enum decl which has an unsigned representation.
  
  /// Return true if this is an integer type that is
  /// unsigned, according to C99 6.2.5p6 [which returns true for _Bool],
  /// or an enum decl which has an unsigned representation.
  
  /// isUnsignedIntegerType - Return true if this is an integer type that is
  /// unsigned, according to C99 6.2.5p6 [which returns true for _Bool], an enum
  /// decl which has an unsigned representation
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isUnsignedIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1746,
   FQN="clang::Type::isUnsignedIntegerType", NM="_ZNK5clang4Type21isUnsignedIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type21isUnsignedIntegerTypeEv")
  //</editor-fold>
  public boolean isUnsignedIntegerType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() >= BuiltinType.Kind.Bool.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.UInt128.getValue();
      }
    }
    {
      
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(CanonicalType);
      if ((ET != null)) {
        // Incomplete enum types are not treated as integer types.
        // FIXME: In C++, enum types are never integer types.
        if (ET.getDecl().isComplete() && !ET.getDecl().isScoped()) {
          return ET.getDecl().getIntegerType().$arrow().isUnsignedIntegerType();
        }
      }
    }
    
    return false;
  }


  
  /// Determines whether this is an integer type that is signed or an
  /// enumeration types whose underlying type is a signed integer type.
  
  /// Determines whether this is an integer type that is signed or an
  /// enumeration types whose underlying type is a signed integer type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isSignedIntegerOrEnumerationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1722,
   FQN="clang::Type::isSignedIntegerOrEnumerationType", NM="_ZNK5clang4Type32isSignedIntegerOrEnumerationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type32isSignedIntegerOrEnumerationTypeEv")
  //</editor-fold>
  public boolean isSignedIntegerOrEnumerationType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() >= BuiltinType.Kind.Char_S.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.Int128.getValue();
      }
    }
    {
      
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(CanonicalType);
      if ((ET != null)) {
        if (ET.getDecl().isComplete()) {
          return ET.getDecl().getIntegerType().$arrow().isSignedIntegerType();
        }
      }
    }
    
    return false;
  }


  
  /// Determines whether this is an integer type that is unsigned or an
  /// enumeration types whose underlying type is a unsigned integer type.
  
  /// Determines whether this is an integer type that is unsigned or an
  /// enumeration types whose underlying type is a unsigned integer type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isUnsignedIntegerOrEnumerationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1762,
   FQN="clang::Type::isUnsignedIntegerOrEnumerationType", NM="_ZNK5clang4Type34isUnsignedIntegerOrEnumerationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type34isUnsignedIntegerOrEnumerationTypeEv")
  //</editor-fold>
  public boolean isUnsignedIntegerOrEnumerationType() /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanonicalType);
      if ((BT != null)) {
        return BT.getKind().getValue() >= BuiltinType.Kind.Bool.getValue()
           && BT.getKind().getValue() <= BuiltinType.Kind.UInt128.getValue();
      }
    }
    {
      
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(CanonicalType);
      if ((ET != null)) {
        if (ET.getDecl().isComplete()) {
          return ET.getDecl().getIntegerType().$arrow().isUnsignedIntegerType();
        }
      }
    }
    
    return false;
  }


  
  /// Return true if this is not a variable sized type,
  /// according to the rules of C99 6.7.5p3.  It is not legal to call this on
  /// incomplete types.
  
  /// Return true if this is not a variable sized type,
  /// according to the rules of C99 6.7.5p3.  It is not legal to call this on
  /// incomplete types.
  
  /// isConstantSizeType - Return true if this is not a variable sized type,
  /// according to the rules of C99 6.7.5p3.  It is not legal to call this on
  /// incomplete types or dependent types.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isConstantSizeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1882,
   FQN="clang::Type::isConstantSizeType", NM="_ZNK5clang4Type18isConstantSizeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type18isConstantSizeTypeEv")
  //</editor-fold>
  public boolean isConstantSizeType() /*const*/ {
    assert (!isIncompleteType()) : "This doesn't make sense for incomplete types";
    assert (!isDependentType()) : "This doesn't make sense for dependent types";
    // The VAT must have a size, as it is known to be complete.
    return !isa_VariableArrayType(CanonicalType);
  }


  
  /// Returns true if this type can be represented by some
  /// set of type specifiers.
  
  /// Returns true if this type can be represented by some
  /// set of type specifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isSpecifierType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2352,
   FQN="clang::Type::isSpecifierType", NM="_ZNK5clang4Type15isSpecifierTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type15isSpecifierTypeEv")
  //</editor-fold>
  public boolean isSpecifierType() /*const*/ {
    // Note that this intentionally does not use the canonical type.
    switch (getTypeClass()) {
     case Builtin:
     case Record:
     case Enum:
     case Typedef:
     case Complex:
     case TypeOfExpr:
     case TypeOf:
     case TemplateTypeParm:
     case SubstTemplateTypeParm:
     case TemplateSpecialization:
     case Elaborated:
     case DependentName:
     case DependentTemplateSpecialization:
     case ObjCInterface:
     case ObjCObject:
     case ObjCObjectPointer: // FIXME: object pointers aren't really specifiers
      return true;
     default:
      return false;
    }
  }


  
  /// Determine the linkage of this type.
  
  /// Determine the linkage of this type.
  
  /// \brief Determine the linkage of this type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getLinkage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3376,
   FQN="clang::Type::getLinkage", NM="_ZNK5clang4Type10getLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type10getLinkageEv")
  //</editor-fold>
  public Linkage getLinkage() /*const*/ {
    TypePropertyCache.$for(Private.class).ensure(this);
    return Unnamed_field.TypeBits.getLinkage();
  }


  
  /// Determine the visibility of this type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1948,
   FQN="clang::Type::getVisibility", NM="_ZNK5clang4Type13getVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type13getVisibilityEv")
  //</editor-fold>
  public Visibility getVisibility() /*const*/ {
    return getLinkageAndVisibility().getVisibility();
  }

  
  /// Return true if the visibility was explicitly set is the code.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isVisibilityExplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1953,
   FQN="clang::Type::isVisibilityExplicit", NM="_ZNK5clang4Type20isVisibilityExplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type20isVisibilityExplicitEv")
  //</editor-fold>
  public boolean isVisibilityExplicit() /*const*/ {
    return getLinkageAndVisibility().isVisibilityExplicit();
  }

  
  /// Determine the linkage and visibility of this type.
  
  /// Determine the linkage and visibility of this type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getLinkageAndVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3471,
   FQN="clang::Type::getLinkageAndVisibility", NM="_ZNK5clang4Type23getLinkageAndVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type23getLinkageAndVisibilityEv")
  //</editor-fold>
  public LinkageInfo getLinkageAndVisibility() /*const*/ {
    if (!isCanonicalUnqualified()) {
      return computeLinkageInfo(getCanonicalTypeInternal());
    }
    
    LinkageInfo LV = computeLinkageInfo(this);
    assert (LV.getLinkage() == getLinkage());
    return LV;
  }


  
  /// True if the computed linkage is valid. Used for consistency
  /// checking. Should always return true.
  
  /// True if the computed linkage is valid. Used for consistency
  /// checking. Should always return true.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::isLinkageValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3463,
   FQN="clang::Type::isLinkageValid", NM="_ZNK5clang4Type14isLinkageValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type14isLinkageValidEv")
  //</editor-fold>
  public boolean isLinkageValid() /*const*/ {
    if (!Unnamed_field.TypeBits.isCacheValid()) {
      return true;
    }
    
    return computeLinkageInfo(getCanonicalTypeInternal()).getLinkage()
       == Unnamed_field.TypeBits.getLinkage();
  }


  
  /// Determine the nullability of the given type.
  ///
  /// Note that nullability is only captured as sugar within the type
  /// system, not as part of the canonical type, so nullability will
  /// be lost by canonicalization and desugaring.
  
  /// Determine the nullability of the given type.
  ///
  /// Note that nullability is only captured as sugar within the type
  /// system, not as part of the canonical type, so nullability will
  /// be lost by canonicalization and desugaring.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getNullability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3480,
   FQN="clang::Type::getNullability", NM="_ZNK5clang4Type14getNullabilityERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type14getNullabilityERKNS_10ASTContextE")
  //</editor-fold>
  public Optional<NullabilityKind> getNullability(final /*const*/ ASTContext /*&*/ context) /*const*/ {
    QualType type/*J*/= new QualType(this, 0);
    do {
      {
        // Check whether this is an attributed type with nullability
        // information.
        /*const*/ AttributedType /*P*/ attributed = dyn_cast_AttributedType(type.getTypePtr());
        if ((attributed != null)) {
          {
            Optional<NullabilityKind> nullability = attributed.getImmediateNullability();
            if (nullability.$bool()) {
              return nullability;
            }
          }
        }
      }
      
      // Desugar the type. If desugaring does nothing, we're done.
      QualType desugared = type.getSingleStepDesugaredType(context);
      if (desugared.getTypePtr() == type.getTypePtr()) {
        return new Optional<NullabilityKind>(None);
      }
      
      type.$assign(desugared);
    } while (true);
  }


  
  /// Determine whether the given type can have a nullability
  /// specifier applied to it, i.e., if it is any kind of pointer type
  /// or a dependent type that could instantiate to any kind of
  /// pointer type.
  
  /// Determine whether the given type can have a nullability
  /// specifier applied to it, i.e., if it is any kind of pointer type
  /// or a dependent type that could instantiate to any kind of
  /// pointer type.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::canHaveNullability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3499,
   FQN="clang::Type::canHaveNullability", NM="_ZNK5clang4Type18canHaveNullabilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type18canHaveNullabilityEv")
  //</editor-fold>
  public boolean canHaveNullability() /*const*/ {
    QualType type = getCanonicalTypeInternal();
    switch (type.$arrow().getTypeClass()) {
     case Paren:
      throw new llvm_unreachable("non-canonical type");
     case Typedef:
      throw new llvm_unreachable("non-canonical type");
     case Adjusted:
      throw new llvm_unreachable("non-canonical type");
     case Decayed:
      throw new llvm_unreachable("non-canonical type");
     case Elaborated:
      throw new llvm_unreachable("non-canonical type");
     case Attributed:
      throw new llvm_unreachable("non-canonical type");
     case SubstTemplateTypeParm:
      throw new llvm_unreachable("non-canonical type");
     case Pointer:
     case BlockPointer:
     case MemberPointer:
     case ObjCObjectPointer:
      
      // Pointer types.
      return true;
     case UnresolvedUsing:
     case TypeOfExpr:
     case TypeOf:
     case Decltype:
     case UnaryTransform:
     case TemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case DependentName:
     case DependentTemplateSpecialization:
      
      // Dependent types that could instantiate to pointer types.
      return true;
     case TemplateSpecialization:
      {
        
        // Dependent template specializations can instantiate to pointer
        // types unless they're known to be specializations of a class
        // template.
        TemplateDecl /*P*/ templateDecl = cast_TemplateSpecializationType(type.getTypePtr()).
            getTemplateName().getAsTemplateDecl();
        if ((templateDecl != null)) {
          if (isa_ClassTemplateDecl(templateDecl)) {
            return false;
          }
        }
      }
      return true;
     case Auto:
      
      // auto is considered dependent when it isn't deduced.
      return !cast_AutoType(type.getTypePtr()).isDeduced();
     case Builtin:
      switch (cast_BuiltinType(type.getTypePtr()).getKind()) {
       case Bool:
       case Char_U:
       case UChar:
       case WChar_U:
       case Char16:
       case Char32:
       case UShort:
       case UInt:
       case ULong:
       case ULongLong:
       case UInt128:
       case Char_S:
       case SChar:
       case WChar_S:
       case Short:
       case Int:
       case Long:
       case LongLong:
       case Int128:
       case Half:
       case Float:
       case Double:
       case LongDouble:
       case Float128:
        return false;
       case Dependent:
       case Overload:
       case BoundMember:
       case PseudoObject:
       case UnknownAny:
       case ARCUnbridgedCast:
        
        // Dependent types that could instantiate to a pointer type.
        return true;
       case Void:
       case ObjCId:
       case ObjCClass:
       case ObjCSel:
       case OCLImage1dRO:
       case OCLImage1dArrayRO:
       case OCLImage1dBufferRO:
       case OCLImage2dRO:
       case OCLImage2dArrayRO:
       case OCLImage2dDepthRO:
       case OCLImage2dArrayDepthRO:
       case OCLImage2dMSAARO:
       case OCLImage2dArrayMSAARO:
       case OCLImage2dMSAADepthRO:
       case OCLImage2dArrayMSAADepthRO:
       case OCLImage3dRO:
       case OCLImage1dWO:
       case OCLImage1dArrayWO:
       case OCLImage1dBufferWO:
       case OCLImage2dWO:
       case OCLImage2dArrayWO:
       case OCLImage2dDepthWO:
       case OCLImage2dArrayDepthWO:
       case OCLImage2dMSAAWO:
       case OCLImage2dArrayMSAAWO:
       case OCLImage2dMSAADepthWO:
       case OCLImage2dArrayMSAADepthWO:
       case OCLImage3dWO:
       case OCLImage1dRW:
       case OCLImage1dArrayRW:
       case OCLImage1dBufferRW:
       case OCLImage2dRW:
       case OCLImage2dArrayRW:
       case OCLImage2dDepthRW:
       case OCLImage2dArrayDepthRW:
       case OCLImage2dMSAARW:
       case OCLImage2dArrayMSAARW:
       case OCLImage2dMSAADepthRW:
       case OCLImage2dArrayMSAADepthRW:
       case OCLImage3dRW:
       case OCLSampler:
       case OCLEvent:
       case OCLClkEvent:
       case OCLQueue:
       case OCLNDRange:
       case OCLReserveID:
       case BuiltinFn:
       case NullPtr:
       case OMPArraySection:
        return false;
       default:
         assert false : "unexpected:" + type.getTypePtr();
      }
     case Complex:
     case LValueReference:
     case RValueReference:
     case ConstantArray:
     case IncompleteArray:
     case VariableArray:
     case DependentSizedArray:
     case DependentSizedExtVector:
     case Vector:
     case ExtVector:
     case FunctionProto:
     case FunctionNoProto:
     case Record:
     case Enum:
     case InjectedClassName:
     case PackExpansion:
     case ObjCObject:
     case ObjCInterface:
     case Atomic:
     case Pipe:
      
      // Non-pointer types.
      return false;
    }
    throw new llvm_unreachable("bad type kind!");
  }


  
  /// Retrieve the set of substitutions required when accessing a member
  /// of the Objective-C receiver type that is declared in the given context.
  ///
  /// \c *this is the type of the object we're operating on, e.g., the
  /// receiver for a message send or the base of a property access, and is
  /// expected to be of some object or object pointer type.
  ///
  /// \param dc The declaration context for which we are building up a
  /// substitution mapping, which should be an Objective-C class, extension,
  /// category, or method within.
  ///
  /// \returns an array of type arguments that can be substituted for
  /// the type parameters of the given declaration context in any type described
  /// within that context, or an empty optional to indicate that no
  /// substitution is required.
  
  /// Retrieve the set of substitutions required when accessing a member
  /// of the Objective-C receiver type that is declared in the given context.
  ///
  /// \c *this is the type of the object we're operating on, e.g., the
  /// receiver for a message send or the base of a property access, and is
  /// expected to be of some object or object pointer type.
  ///
  /// \param dc The declaration context for which we are building up a
  /// substitution mapping, which should be an Objective-C class, extension,
  /// category, or method within.
  ///
  /// \returns an array of type arguments that can be substituted for
  /// the type parameters of the given declaration context in any type described
  /// within that context, or an empty optional to indicate that no
  /// substitution is required.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getObjCSubstitutions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1283,
   FQN="clang::Type::getObjCSubstitutions", NM="_ZNK5clang4Type20getObjCSubstitutionsEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type20getObjCSubstitutionsEPKNS_11DeclContextE")
  //</editor-fold>
  public Optional<ArrayRef<QualType> > getObjCSubstitutions(/*const*/ DeclContext /*P*/ dc) /*const*/ {
    {
      // Look through method scopes.
      /*const*/ ObjCMethodDecl /*P*/ method = dyn_cast_ObjCMethodDecl(dc);
      if ((method != null)) {
        dc = method.getDeclContext$Const();
      }
    }
    
    // Find the class or category in which the type we're substituting
    // was declared.
    /*const*/ ObjCInterfaceDecl /*P*/ dcClassDecl = dyn_cast_ObjCInterfaceDecl(dc);
    /*const*/ ObjCCategoryDecl /*P*/ dcCategoryDecl = null;
    ObjCTypeParamList /*P*/ dcTypeParams = null;
    if ((dcClassDecl != null)) {
      // If the class does not have any type parameters, there's no
      // substitution to do.
      dcTypeParams = dcClassDecl.getTypeParamList();
      if (!(dcTypeParams != null)) {
        return new Optional<ArrayRef<QualType> >(None);
      }
    } else {
      // If we are in neither a class nor a category, there's no
      // substitution to perform.
      dcCategoryDecl = dyn_cast_ObjCCategoryDecl(dc);
      if (!(dcCategoryDecl != null)) {
        return new Optional<ArrayRef<QualType> >(None);
      }
      
      // If the category does not have any type parameters, there's no
      // substitution to do.
      dcTypeParams = dcCategoryDecl.getTypeParamList();
      if (!(dcTypeParams != null)) {
        return new Optional<ArrayRef<QualType> >(None);
      }
      
      dcClassDecl = dcCategoryDecl.getClassInterface$Const();
      if (!(dcClassDecl != null)) {
        return new Optional<ArrayRef<QualType> >(None);
      }
    }
    assert ((dcTypeParams != null)) : "No substitutions to perform";
    assert ((dcClassDecl != null)) : "No class context";
    
    // Find the underlying object type.
    /*const*/ ObjCObjectType /*P*/ objectType;
    {
      /*const*/ ObjCObjectPointerType /*P*/ objectPointerType = getAs(ObjCObjectPointerType.class);
      if ((objectPointerType != null)) {
        objectType = objectPointerType.getObjectType();
      } else if ((getAs(BlockPointerType.class) != null)) {
        final ASTContext /*&*/ ctx = dc.getParentASTContext();
        objectType = ctx.getObjCObjectType(ctx.ObjCBuiltinIdTy.$QualType(), ((type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/>)/*zero-init*/null), ((/*uint*/int)/*zero-init*/0)).$arrow().castAs(ObjCObjectType.class);
        ;
      } else {
        objectType = getAs(ObjCObjectType.class);
      }
    }
    
    /// Extract the class from the receiver object type.
    ObjCInterfaceDecl /*P*/ curClassDecl = (objectType != null) ? objectType.getInterface() : null;
    if (!(curClassDecl != null)) {
      // If we don't have a context type (e.g., this is "id" or some
      // variant thereof), substitute the bounds.
      return new Optional<ArrayRef<QualType> >(JD$T$RR.INSTANCE, new ArrayRef<QualType>(false));
    }
    
    // Follow the superclass chain until we've mapped the receiver type
    // to the same class as the context.
    while (curClassDecl != dcClassDecl) {
      // Map to the superclass type.
      QualType superType = objectType.getSuperClassType();
      if (superType.isNull()) {
        objectType = null;
        break;
      }
      
      objectType = superType.$arrow().castAs(ObjCObjectType.class);
      curClassDecl = objectType.getInterface();
    }
    
    // If we don't have a receiver type, or the receiver type does not
    // have type arguments, substitute in the defaults.
    if (!(objectType != null) || objectType.isUnspecialized()) {
      return new Optional<ArrayRef<QualType> >(JD$T$RR.INSTANCE, new ArrayRef<QualType>(false));
    }
    
    // The receiver type has the type arguments we want.
    return new Optional<ArrayRef<QualType> >(JD$T$RR.INSTANCE, objectType.getTypeArgs());
  }


  
  /// Determines if this is an ObjC interface type that may accept type
  /// parameters.
  
  /// Determines if this is an ObjC interface type that may accept type
  /// parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::Type::acceptsObjCTypeParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1365,
   FQN="clang::Type::acceptsObjCTypeParams", NM="_ZNK5clang4Type21acceptsObjCTypeParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type21acceptsObjCTypeParamsEv")
  //</editor-fold>
  public boolean acceptsObjCTypeParams() /*const*/ {
    {
      /*const*/ ObjCObjectType /*P*/ IfaceT = getAsObjCInterfaceType();
      if ((IfaceT != null)) {
        {
          ObjCInterfaceDecl /*P*/ ID = IfaceT.getInterface();
          if ((ID != null)) {
            if ((ID.getTypeParamList() != null)) {
              return true;
            }
          }
        }
      }
    }
    
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getTypeClassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2509,
   FQN="clang::Type::getTypeClassName", NM="_ZNK5clang4Type16getTypeClassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type16getTypeClassNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getTypeClassName() /*const*/ {
    switch (TypeClass.valueOf($8bits_uint2uint(Unnamed_field.TypeBits.TC))) {
     case Builtin:
      return $("Builtin");
     case Complex:
      return $("Complex");
     case Pointer:
      return $("Pointer");
     case BlockPointer:
      return $("BlockPointer");
     case LValueReference:
      return $("LValueReference");
     case RValueReference:
      return $("RValueReference");
     case MemberPointer:
      return $("MemberPointer");
     case ConstantArray:
      return $("ConstantArray");
     case IncompleteArray:
      return $("IncompleteArray");
     case VariableArray:
      return $("VariableArray");
     case DependentSizedArray:
      return $("DependentSizedArray");
     case DependentSizedExtVector:
      return $("DependentSizedExtVector");
     case Vector:
      return $("Vector");
     case ExtVector:
      return $("ExtVector");
     case FunctionProto:
      return $("FunctionProto");
     case FunctionNoProto:
      return $("FunctionNoProto");
     case UnresolvedUsing:
      return $("UnresolvedUsing");
     case Paren:
      return $("Paren");
     case Typedef:
      return $("Typedef");
     case Adjusted:
      return $("Adjusted");
     case Decayed:
      return $("Decayed");
     case TypeOfExpr:
      return $("TypeOfExpr");
     case TypeOf:
      return $("TypeOf");
     case Decltype:
      return $("Decltype");
     case UnaryTransform:
      return $("UnaryTransform");
     case Record:
      return $("Record");
     case Enum:
      return $("Enum");
     case Elaborated:
      return $("Elaborated");
     case Attributed:
      return $("Attributed");
     case TemplateTypeParm:
      return $("TemplateTypeParm");
     case SubstTemplateTypeParm:
      return $("SubstTemplateTypeParm");
     case SubstTemplateTypeParmPack:
      return $("SubstTemplateTypeParmPack");
     case TemplateSpecialization:
      return $("TemplateSpecialization");
     case Auto:
      return $("Auto");
     case InjectedClassName:
      return $("InjectedClassName");
     case DependentName:
      return $("DependentName");
     case DependentTemplateSpecialization:
      return $("DependentTemplateSpecialization");
     case PackExpansion:
      return $("PackExpansion");
     case ObjCObject:
      return $("ObjCObject");
     case ObjCInterface:
      return $("ObjCInterface");
     case ObjCObjectPointer:
      return $("ObjCObjectPointer");
     case Pipe:
      return $("Pipe");
     case Atomic:
      return $("Atomic");
    }
    throw new llvm_unreachable("Invalid type class.");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Type::getCanonicalTypeInternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2001,
   FQN="clang::Type::getCanonicalTypeInternal", NM="_ZNK5clang4Type24getCanonicalTypeInternalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type24getCanonicalTypeInternalEv")
  //</editor-fold>
  public QualType getCanonicalTypeInternal() /*const*/ {
    return new QualType(CanonicalType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Type::getCanonicalTypeUnqualified">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 200,
   FQN="clang::Type::getCanonicalTypeUnqualified", NM="_ZNK5clang4Type27getCanonicalTypeUnqualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type27getCanonicalTypeUnqualifiedEv")
  //</editor-fold>
  public /*inline*/ CanQual<Type> getCanonicalTypeUnqualified() /*const*/ {
    return CanQual.<Type>CreateUnsafe(getCanonicalTypeInternal());
  }
 // in CanonicalType.h
  //<editor-fold defaultstate="collapsed" desc="clang::Type::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2459,
   FQN="clang::Type::dump", NM="_ZNK5clang4Type4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    new QualType(this, 0).dump();
  }

  
  /*friend  class ASTReader*/
  /*friend  class ASTWriter*/

  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 117,
   FQN="clang::Type::getAs", NM="_ZNK5clang4Type5getAsINS_8EnumTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type5getAsINS_8EnumTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ EnumType /*P*/ getAs$EnumType() /*const*/ {
    return dyn_cast_EnumType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::castAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 117,
   FQN="clang::Type::castAs", NM="_ZNK5clang4Type6castAsINS_8EnumTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type6castAsINS_8EnumTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ EnumType /*P*/ castAs$EnumType() /*const*/ {
    return cast_EnumType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 118,
   FQN="clang::Type::getAs", NM="_ZNK5clang4Type5getAsINS_11BuiltinTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type5getAsINS_11BuiltinTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ BuiltinType /*P*/ getAs$BuiltinType() /*const*/ {
    return dyn_cast_BuiltinType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::castAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 118,
   FQN="clang::Type::castAs", NM="_ZNK5clang4Type6castAsINS_11BuiltinTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type6castAsINS_11BuiltinTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ BuiltinType /*P*/ castAs$BuiltinType() /*const*/ {
    return cast_BuiltinType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 119,
   FQN="clang::Type::getAs", NM="_ZNK5clang4Type5getAsINS_10RecordTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type5getAsINS_10RecordTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ RecordType /*P*/ getAs$RecordType() /*const*/ {
    return dyn_cast_RecordType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::castAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 119,
   FQN="clang::Type::castAs", NM="_ZNK5clang4Type6castAsINS_10RecordTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type6castAsINS_10RecordTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ RecordType /*P*/ castAs$RecordType() /*const*/ {
    return cast_RecordType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 120,
   FQN="clang::Type::getAs", NM="_ZNK5clang4Type5getAsINS_21InjectedClassNameTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type5getAsINS_21InjectedClassNameTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ InjectedClassNameType /*P*/ getAs$InjectedClassNameType() /*const*/ {
    return dyn_cast_InjectedClassNameType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::castAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 120,
   FQN="clang::Type::castAs", NM="_ZNK5clang4Type6castAsINS_21InjectedClassNameTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type6castAsINS_21InjectedClassNameTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ InjectedClassNameType /*P*/ castAs$InjectedClassNameType() /*const*/ {
    return cast_InjectedClassNameType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 121,
   FQN="clang::Type::getAs", NM="_ZNK5clang4Type5getAsINS_17ObjCInterfaceTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type5getAsINS_17ObjCInterfaceTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ ObjCInterfaceType /*P*/ getAs$ObjCInterfaceType() /*const*/ {
    return dyn_cast_ObjCInterfaceType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::castAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 121,
   FQN="clang::Type::castAs", NM="_ZNK5clang4Type6castAsINS_17ObjCInterfaceTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type6castAsINS_17ObjCInterfaceTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ ObjCInterfaceType /*P*/ castAs$ObjCInterfaceType() /*const*/ {
    return cast_ObjCInterfaceType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 122,
   FQN="clang::Type::getAs", NM="_ZNK5clang4Type5getAsINS_20TemplateTypeParmTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type5getAsINS_20TemplateTypeParmTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ TemplateTypeParmType /*P*/ getAs$TemplateTypeParmType() /*const*/ {
    return dyn_cast_TemplateTypeParmType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::castAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 122,
   FQN="clang::Type::castAs", NM="_ZNK5clang4Type6castAsINS_20TemplateTypeParmTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Type6castAsINS_20TemplateTypeParmTypeEEEPKT_v")
  //</editor-fold>
  public /*inline*/ /*const*/ TemplateTypeParmType /*P*/ castAs$TemplateTypeParmType() /*const*/ {
    return cast_TemplateTypeParmType(CanonicalType);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 326,
   FQN="clang::Type::getAs", NM="_ZNK5clang4Type5getAsINS_11TypedefTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type5getAsINS_11TypedefTypeEEEPKT_v")
  //</editor-fold>
  public /*const*/ TypedefType /*P*/ getAs$TypedefType() /*const*/ {
    return getAsSugar(TypedefType.class, this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 330,
   FQN="clang::Type::getAs", NM="_ZNK5clang4Type5getAsINS_26TemplateSpecializationTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type5getAsINS_26TemplateSpecializationTypeEEEPKT_v")
  //</editor-fold>
  public /*const*/ TemplateSpecializationType /*P*/ getAs$TemplateSpecializationType() /*const*/ {
    return getAsSugar(TemplateSpecializationType.class, this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Type::getAs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 334,
   FQN="clang::Type::getAs", NM="_ZNK5clang4Type5getAsINS_14AttributedTypeEEEPKT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang4Type5getAsINS_14AttributedTypeEEEPKT_v")
  //</editor-fold>
  public /*const*/ AttributedType /*P*/ getAs$AttributedType() /*const*/ {
    return getAsSugar(AttributedType.class, this);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected Type() { /*added to allow subclasses to use $Type(args) when args uses 'this'*/ }
          
  protected Type(TypeClass tc, QualType canon, boolean Dependent, 
      boolean InstantiationDependent, boolean VariablyModified, 
      boolean ContainsUnexpandedParameterPack) {
    $Type(tc, canon, Dependent, InstantiationDependent, VariablyModified, ContainsUnexpandedParameterPack);
  }



  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    String AsString = QualType.getAsString(this, new Qualifiers()).toJavaString();
    if (getClass() != Type.class) {
      return "\n" + AsString;
    }
    return AsString;
  }
}
