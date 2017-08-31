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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.impl.TypeLocStatics.*;


/// \brief Base wrapper for a particular "section" of type source info.
///
/// A client should use the TypeLoc subclasses through castAs()/getAs()
/// in order to get at the actual information.
//<editor-fold defaultstate="collapsed" desc="clang::TypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 40,
 FQN="clang::TypeLoc", NM="_ZN5clang7TypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLocE")
//</editor-fold>
public class TypeLoc implements Native.Native$Bool, NativePOD<TypeLoc> {
/*protected:*/
  // The correctness of this relies on the property that, for Type *Ty,
  //   QualType(Ty, 0).getAsOpaquePtr() == (void*) Ty
  protected /*const*/Object/*void P*/ Ty;
  protected type$ptr<?>/*void P*/ Data;
  // we store values like SourceLocation and they should be copied, not shared
  // when pointers are kept, then initJavaExtraLocalData must check that pointers are not of cloneable types.
  // TODO: If it fails, then probably only local data is stored by value
  public static final boolean DATA_DEEP_COPY = true; 
/*public:*/
  /// \brief Convert to the specified TypeLoc type, asserting that this TypeLoc
  /// is of the desired type.
  ///
  /// \pre T::isKind(*this)
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::castAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 53,
   FQN="clang::TypeLoc::castAs", NM="Tpl__ZNK5clang7TypeLoc6castAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=Tpl__ZNK5clang7TypeLoc6castAsEv")
  //</editor-fold>
  public </*typename*/ T extends TypeLoc> T castAs(Class<T> typeLocClass) /*const*/ {
    assert Native.$bool(TypeLoc.isKind(typeLocClass, /*Deref*/this)) : "this " + this.getClass() + " must be convertable to " + typeLocClass;
    T t = TypeLocToTypeLocInstance(typeLocClass);
    TypeLoc t1 = t;
    t1.$assign(/*Deref*/this);
    return t;
  }

  
  /// \brief Convert to the specified TypeLoc type, returning a null TypeLoc if
  /// this TypeLoc is not of the desired type.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 64,
   FQN="clang::TypeLoc::getAs", NM="Tpl__ZNK5clang7TypeLoc5getAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=Tpl__ZNK5clang7TypeLoc5getAsEv")
  //</editor-fold>
  public </*typename*/ T extends TypeLoc> T getAs(Class<T> typeLocClass) /*const*/ {
    T t = TypeLocToTypeLocInstance(typeLocClass);
    if (Native.$not(TypeLoc.isKind(typeLocClass, /*Deref*/this))) {
      return t;
    }
    final TypeLoc /*&*/ tl = t;
    tl.$assign(/*Deref*/this);
    return t;
  }
  
  
  /// The kinds of TypeLocs.  Equivalent to the Type::TypeClass enum,
  /// except it also defines a Qualified enum that corresponds to the
  /// QualifiedLoc class.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::TypeLocClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 76,
   FQN="clang::TypeLoc::TypeLocClass", NM="_ZN5clang7TypeLoc12TypeLocClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLoc12TypeLocClassE")
  //</editor-fold>
  public enum TypeLocClass implements Native.ComparableLower {
    Builtin(Type.TypeClass.Builtin.getValue()),
    Complex(Type.TypeClass.Complex.getValue()),
    Pointer(Type.TypeClass.Pointer.getValue()),
    BlockPointer(Type.TypeClass.BlockPointer.getValue()),
    LValueReference(Type.TypeClass.LValueReference.getValue()),
    RValueReference(Type.TypeClass.RValueReference.getValue()),
    MemberPointer(Type.TypeClass.MemberPointer.getValue()),
    ConstantArray(Type.TypeClass.ConstantArray.getValue()),
    IncompleteArray(Type.TypeClass.IncompleteArray.getValue()),
    VariableArray(Type.TypeClass.VariableArray.getValue()),
    DependentSizedArray(Type.TypeClass.DependentSizedArray.getValue()),
    DependentSizedExtVector(Type.TypeClass.DependentSizedExtVector.getValue()),
    Vector(Type.TypeClass.Vector.getValue()),
    ExtVector(Type.TypeClass.ExtVector.getValue()),
    FunctionProto(Type.TypeClass.FunctionProto.getValue()),
    FunctionNoProto(Type.TypeClass.FunctionNoProto.getValue()),
    UnresolvedUsing(Type.TypeClass.UnresolvedUsing.getValue()),
    Paren(Type.TypeClass.Paren.getValue()),
    Typedef(Type.TypeClass.Typedef.getValue()),
    Adjusted(Type.TypeClass.Adjusted.getValue()),
    Decayed(Type.TypeClass.Decayed.getValue()),
    TypeOfExpr(Type.TypeClass.TypeOfExpr.getValue()),
    TypeOf(Type.TypeClass.TypeOf.getValue()),
    Decltype(Type.TypeClass.Decltype.getValue()),
    UnaryTransform(Type.TypeClass.UnaryTransform.getValue()),
    Record(Type.TypeClass.Record.getValue()),
    Enum(Type.TypeClass.Enum.getValue()),
    Elaborated(Type.TypeClass.Elaborated.getValue()),
    Attributed(Type.TypeClass.Attributed.getValue()),
    TemplateTypeParm(Type.TypeClass.TemplateTypeParm.getValue()),
    SubstTemplateTypeParm(Type.TypeClass.SubstTemplateTypeParm.getValue()),
    SubstTemplateTypeParmPack(Type.TypeClass.SubstTemplateTypeParmPack.getValue()),
    TemplateSpecialization(Type.TypeClass.TemplateSpecialization.getValue()),
    Auto(Type.TypeClass.Auto.getValue()),
    InjectedClassName(Type.TypeClass.InjectedClassName.getValue()),
    DependentName(Type.TypeClass.DependentName.getValue()),
    DependentTemplateSpecialization(Type.TypeClass.DependentTemplateSpecialization.getValue()),
    PackExpansion(Type.TypeClass.PackExpansion.getValue()),
    ObjCObject(Type.TypeClass.ObjCObject.getValue()),
    ObjCInterface(Type.TypeClass.ObjCInterface.getValue()),
    ObjCObjectPointer(Type.TypeClass.ObjCObjectPointer.getValue()),
    Pipe(Type.TypeClass.Pipe.getValue()),
    Atomic(Type.TypeClass.Atomic.getValue()),
    Qualified(Atomic.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TypeLocClass valueOf(int val) {
      TypeLocClass out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TypeLocClass[] VALUES;
      private static final TypeLocClass[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TypeLocClass kind : TypeLocClass.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TypeLocClass[min < 0 ? (1-min) : 0];
        VALUES = new TypeLocClass[max >= 0 ? (1+max) : 0];
        for (TypeLocClass kind : TypeLocClass.values()) {
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
    private TypeLocClass(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TypeLocClass)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TypeLocClass)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::TypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 84,
   FQN="clang::TypeLoc::TypeLoc", NM="_ZN5clang7TypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLocC1Ev")
  //</editor-fold>
  public TypeLoc() {
    // : Ty(null), Data(null) 
    //START JInit
    this.Ty = null;
    this.Data = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::TypeLoc">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 85,
   FQN="clang::TypeLoc::TypeLoc", NM="_ZN5clang7TypeLocC1ENS_8QualTypeEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLocC1ENS_8QualTypeEPv")
  //</editor-fold>
  public TypeLoc(QualType ty, type$ptr<?>/*void P*/ opaqueData) {
    // : Ty(ty.getAsOpaquePtr()), Data(opaqueData) 
    //START JInit
    this.Ty = ty.getAsOpaquePtr();
    this.Data = $toConst(opaqueData);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::TypeLoc">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 87,
   FQN="clang::TypeLoc::TypeLoc", NM="_ZN5clang7TypeLocC1EPKNS_4TypeEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLocC1EPKNS_4TypeEPv")
  //</editor-fold>
  public TypeLoc(/*const*/ Type /*P*/ ty, type$ptr<?>/*void P*/ opaqueData) {
    // : Ty(ty), Data(opaqueData) 
    //START JInit
    this.Ty = ty;
    this.Data = $toConst(opaqueData);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getTypeLocClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 90,
   FQN="clang::TypeLoc::getTypeLocClass", NM="_ZNK5clang7TypeLoc15getTypeLocClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc15getTypeLocClassEv")
  //</editor-fold>
  public TypeLocClass getTypeLocClass() /*const*/ {
    if (getType().hasLocalQualifiers()) {
      return TypeLocClass.Qualified;
    }
    return TypeLocClass.valueOf(getType().$arrow().getTypeClass().getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::isNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 95,
   FQN="clang::TypeLoc::isNull", NM="_ZNK5clang7TypeLoc6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc6isNullEv")
  //</editor-fold>
  public boolean isNull() /*const*/ {
    return !(Ty != null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 96,
   FQN="clang::TypeLoc::operator bool", NM="_ZNK5clang7TypeLoccvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoccvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return (Ty != null);
  }

  
  /// \brief Returns the size of type source info data block for the given type.
  
  /// \brief Returns the size of the type source info data block.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getFullDataSizeForType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 76,
   FQN="clang::TypeLoc::getFullDataSizeForType", NM="_ZN5clang7TypeLoc22getFullDataSizeForTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLoc22getFullDataSizeForTypeENS_8QualTypeE")
  //</editor-fold>
  public static /*uint*/int getFullDataSizeForType(QualType Ty) {
    /*uint*/int Total = 0;
    TypeLoc TyLoc/*J*/= new TypeLoc(/*NO_COPY*/Ty, (type$ptr<?>/*void P*/ )null);
    /*uint*/int MaxAlign = 1;
    while (!TyLoc.isNull()) {
      /*uint*/int Align = getLocalAlignmentForType(TyLoc.getType());
      MaxAlign = std.max(Align, MaxAlign);
      Total = $ulong2uint(llvm.alignTo($uint2ulong(Total), $uint2ulong(Align)));
      Total += new TypeSizer().Visit(TyLoc);
      TyLoc.$assignMove(TyLoc.getNextTypeLoc());
    }
    Total = $ulong2uint(llvm.alignTo($uint2ulong(Total), $uint2ulong(MaxAlign)));
    return Total;
  }

  
  /// \brief Returns the alignment of type source info data block for
  /// the given type.
  
  /// \brief Returns the alignment of the type source info data block.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getLocalAlignmentForType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 58,
   FQN="clang::TypeLoc::getLocalAlignmentForType", NM="_ZN5clang7TypeLoc24getLocalAlignmentForTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLoc24getLocalAlignmentForTypeENS_8QualTypeE")
  //</editor-fold>
  public static /*uint*/int getLocalAlignmentForType(QualType Ty) {
    if (Ty.isNull()) {
      return 1;
    }
    return new TypeAligner().Visit(new TypeLoc(/*NO_COPY*/Ty, (type$ptr<?>/*void P*/ )null));
  }

  
  /// \brief Get the type for which this source info wrapper provides
  /// information.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 107,
   FQN="clang::TypeLoc::getType", NM="_ZNK5clang7TypeLoc7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc7getTypeEv")
  //</editor-fold>
  public QualType getType() /*const*/ {
    return QualType.getFromOpaquePtr(Ty);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getTypePtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 111,
   FQN="clang::TypeLoc::getTypePtr", NM="_ZNK5clang7TypeLoc10getTypePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc10getTypePtrEv")
  //</editor-fold>
  public /*const*/ Type /*P*/ getTypePtr() /*const*/ {
    return QualType.getFromOpaquePtr(Ty).getTypePtr();
  }

  
  /// \brief Get the pointer where source information is stored.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getOpaqueData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 116,
   FQN="clang::TypeLoc::getOpaqueData", NM="_ZNK5clang7TypeLoc13getOpaqueDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc13getOpaqueDataEv")
  //</editor-fold>
  public type$ptr<?>/*void P*/ getOpaqueData() /*const*/ {
    return Data;
  }

  
  /// \brief Get the begin source location.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getBeginLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 170,
   FQN="clang::TypeLoc::getBeginLoc", NM="_ZNK5clang7TypeLoc11getBeginLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc11getBeginLocEv")
  //</editor-fold>
  public SourceLocation getBeginLoc() /*const*/ {
    TypeLoc Cur = new TypeLoc(/*Deref*/this);
    TypeLoc LeftMost = new TypeLoc(Cur);
    while (true) {
      switch (Cur.getTypeLocClass()) {
       case Elaborated:
        LeftMost.$assign(Cur);
        break;
       case FunctionProto:
        if (Cur.castAs(FunctionProtoTypeLoc.class).getTypePtr().
            hasTrailingReturn()) {
          LeftMost.$assign(Cur);
          break;
        }
       case FunctionNoProto:
       case ConstantArray:
       case DependentSizedArray:
       case IncompleteArray:
       case VariableArray:
       case Qualified:
        // FIXME: Currently QualifiedTypeLoc does not have a source range
        Cur.$assignMove(Cur.getNextTypeLoc());
        continue;
       default:
        if (Cur.getLocalSourceRange().getBegin().isValid()) {
          LeftMost.$assign(Cur);
        }
        Cur.$assignMove(Cur.getNextTypeLoc());
        if (Cur.isNull()) {
          break;
        }
        continue;
      } // switch
      break;
    } // while
    return LeftMost.getLocalSourceRange().getBegin();
  }

  
  /// \brief Get the end source location.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 207,
   FQN="clang::TypeLoc::getEndLoc", NM="_ZNK5clang7TypeLoc9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    TypeLoc Cur = new TypeLoc(/*Deref*/this);
    TypeLoc Last/*J*/= new TypeLoc();
    while (true) {
      switch (Cur.getTypeLocClass()) {
       default:
        if (!Last.$bool()) {
          Last.$assign(Cur);
        }
        return Last.getLocalSourceRange().getEnd();
       case Paren:
       case ConstantArray:
       case DependentSizedArray:
       case IncompleteArray:
       case VariableArray:
       case FunctionNoProto:
        Last.$assign(Cur);
        break;
       case FunctionProto:
        if (Cur.castAs(FunctionProtoTypeLoc.class).getTypePtr().hasTrailingReturn()) {
          Last.$assignMove(new TypeLoc());
        } else {
          Last.$assign(Cur);
        }
        break;
       case Pointer:
       case BlockPointer:
       case MemberPointer:
       case LValueReference:
       case RValueReference:
       case PackExpansion:
        if (!Last.$bool()) {
          Last.$assign(Cur);
        }
        break;
       case Qualified:
       case Elaborated:
        break;
      }
      Cur.$assignMove(Cur.getNextTypeLoc());
    }
  }

  
  /// \brief Get the full source range.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 127,
   FQN="clang::TypeLoc::getSourceRange", NM="_ZNK5clang7TypeLoc14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(getBeginLoc(), getEndLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 130,
   FQN="clang::TypeLoc::getLocStart", NM="_ZNK5clang7TypeLoc11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getBeginLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 131,
   FQN="clang::TypeLoc::getLocEnd", NM="_ZNK5clang7TypeLoc9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getEndLoc();
  }

  
  /// \brief Get the local source range.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 134,
   FQN="clang::TypeLoc::getLocalSourceRange", NM="_ZNK5clang7TypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return getLocalSourceRangeImpl(new TypeLoc(/*Deref*/this));
  }

  
  /// \brief Returns the size of the type source info data block.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getFullDataSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 139,
   FQN="clang::TypeLoc::getFullDataSize", NM="_ZNK5clang7TypeLoc15getFullDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc15getFullDataSizeEv")
  //</editor-fold>
  public /*uint*/int getFullDataSize() /*const*/ {
    return getFullDataSizeForType(getType());
  }

  
  /// \brief Get the next TypeLoc pointed by this TypeLoc, e.g for "int*" the
  /// TypeLoc is a PointerLoc and next TypeLoc is for "int".
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getNextTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 145,
   FQN="clang::TypeLoc::getNextTypeLoc", NM="_ZNK5clang7TypeLoc14getNextTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc14getNextTypeLocEv")
  //</editor-fold>
  public TypeLoc getNextTypeLoc() /*const*/ {
    return getNextTypeLocImpl(/*Deref*/this);
  }

  
  /// \brief Skips past any qualifiers, if this is qualified.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getUnqualifiedLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 297,
   FQN="clang::TypeLoc::getUnqualifiedLoc", NM="_ZNK5clang7TypeLoc17getUnqualifiedLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc17getUnqualifiedLocEv")
  //</editor-fold>
  public /*inline*/ UnqualTypeLoc getUnqualifiedLoc() /*const*/ {
    {
      QualifiedTypeLoc Loc = getAs(QualifiedTypeLoc.class);
      if (Loc.$bool()) {
        return Loc.getUnqualifiedLoc();
      }
    }
    return castAs(UnqualTypeLoc.class);
  }
 // implemented in this header
  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::IgnoreParens">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use TypeLoc.isKind*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1056,
   FQN="clang::TypeLoc::IgnoreParens", NM="_ZNK5clang7TypeLoc12IgnoreParensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc12IgnoreParensEv")
  //</editor-fold>
  public /*inline*/ TypeLoc IgnoreParens() /*const*/ {
    if (TypeLoc.isKind(ParenTypeLoc.class, /*Deref*/this)) {
      return IgnoreParensImpl(new TypeLoc(/*Deref*/this));
    }
    return new TypeLoc(/*Deref*/this);
  }

  
  /// \brief Find a type with the location of an explicit type qualifier.
  ///
  /// The result, if non-null, will be one of:
  ///   QualifiedTypeLoc
  ///   AtomicTypeLoc
  ///   AttributedTypeLoc, for those type attributes that behave as qualifiers
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::findExplicitQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 371,
   FQN="clang::TypeLoc::findExplicitQualifierLoc", NM="_ZNK5clang7TypeLoc24findExplicitQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc24findExplicitQualifierLocEv")
  //</editor-fold>
  public TypeLoc findExplicitQualifierLoc() /*const*/ {
    {
      // Qualified types.
      QualifiedTypeLoc qual = getAs(QualifiedTypeLoc.class);
      if (qual.$bool()) {
        return new TypeLoc(qual);
      }
    }
    
    TypeLoc loc = IgnoreParens();
    {
      
      // Attributed types.
      AttributedTypeLoc attr = loc.getAs(AttributedTypeLoc.class);
      if (attr.$bool()) {
        if (attr.isQualifier()) {
          return new TypeLoc(attr);
        }
        return attr.getModifiedLoc().findExplicitQualifierLoc();
      }
    }
    {
      
      // C11 _Atomic types.
      AtomicTypeLoc atomic = loc.getAs(AtomicTypeLoc.class);
      if (atomic.$bool()) {
        return new TypeLoc(atomic);
      }
    }
    
    return new TypeLoc();
  }

  
  /// \brief Initializes this to state that every location in this
  /// type is the given location.
  ///
  /// This method exists to provide a simple transition for code that
  /// relies on location-less types.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 167,
   FQN="clang::TypeLoc::initialize", NM="_ZNK5clang7TypeLoc10initializeERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc10initializeERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void initialize(final ASTContext /*&*/ Context, SourceLocation Loc) /*const*/ {
    initializeImpl(Context, new TypeLoc(/*Deref*/this), new SourceLocation(Loc));
  }

  
  /// \brief Initializes this by copying its information from another
  /// TypeLoc of the same type.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::initializeFullCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 173,
   FQN="clang::TypeLoc::initializeFullCopy", NM="_ZN5clang7TypeLoc18initializeFullCopyES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLoc18initializeFullCopyES0_")
  //</editor-fold>
  public void initializeFullCopy(TypeLoc Other) {
    assert ($eq_QualType$C(getType(), Other.getType()));
    copy(new TypeLoc(Other));
  }

  
  /// \brief Initializes this by copying its information from another
  /// TypeLoc of the same type.  The given size must be the full data
  /// size.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::initializeFullCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 181,
   FQN="clang::TypeLoc::initializeFullCopy", NM="_ZN5clang7TypeLoc18initializeFullCopyES0_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLoc18initializeFullCopyES0_j")
  //</editor-fold>
  public void initializeFullCopy(TypeLoc Other, /*uint*/int Size) {
    assert ($eq_QualType$C(getType(), Other.getType()));
    assert (getFullDataSize() == Size);
    copy(new TypeLoc(Other));
  }

  
  /// Copies the other type loc into this one.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::copy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 146,
   FQN="clang::TypeLoc::copy", NM="_ZN5clang7TypeLoc4copyES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLoc4copyES0_")
  //</editor-fold>
  public void copy(TypeLoc other) {
    assert (getFullDataSize() == other.getFullDataSize());
    
    // If both data pointers are aligned to the maximum alignment, we
    // can memcpy because getFullDataSize() accurately reflects the
    // layout of the data.
    // JAVA: not sure this will fly
    if (Data.$index()
       == llvm.alignTo(Data.$index(), TypeLocMaxDataAlign)
       && other.Data.$index()
       == llvm.alignTo(other.Data.$index(), 
          TypeLocMaxDataAlign)) {
      memcpy(Data, other.Data, getFullDataSize(), TypeLoc.DATA_DEEP_COPY);
      return;
    }

    // Copy each of the pieces.
    TypeLoc TL/*J*/= new TypeLoc(getType(), Data);
    do {
      new TypeLocCopier(new TypeLoc(other)).Visit(new TypeLoc(TL));
      other.$assignMove(other.getNextTypeLoc());
    } while ((TL.$assignMove(TL.getNextTypeLoc())).$bool());
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 190,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_7TypeLocES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clangeqERKNS_7TypeLocES2_")
  //</editor-fold>
  public static boolean $eq_TypeLoc$C(final /*const*/ TypeLoc /*&*/ LHS, final /*const*/ TypeLoc /*&*/ RHS) {
    return $eq_ptr(LHS.Ty, RHS.Ty) && $eq_ptr(LHS.Data, RHS.Data);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 194,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_7TypeLocES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clangneERKNS_7TypeLocES2_")
  //</editor-fold>
  public static boolean $noteq_TypeLoc$C(final /*const*/ TypeLoc /*&*/ LHS, final /*const*/ TypeLoc /*&*/ RHS) {
    return !($eq_TypeLoc$C(LHS, RHS));
  }

  
  /// Find the location of the nullability specifier (__nonnull,
  /// __nullable, or __null_unspecifier), if there is one.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::findNullabilityLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 360,
   FQN="clang::TypeLoc::findNullabilityLoc", NM="_ZNK5clang7TypeLoc18findNullabilityLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang7TypeLoc18findNullabilityLocEv")
  //</editor-fold>
  public SourceLocation findNullabilityLoc() /*const*/ {
    {
      AttributedTypeLoc attributedLoc = getAs(AttributedTypeLoc.class);
      if (attributedLoc.$bool()) {
        if (attributedLoc.getAttrKind() == AttributedType.Kind.attr_nullable
           || attributedLoc.getAttrKind() == AttributedType.Kind.attr_nonnull
           || attributedLoc.getAttrKind() == AttributedType.Kind.attr_null_unspecified) {
          return attributedLoc.getAttrNameLoc();
        }
      }
    }
    
    return new SourceLocation();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 203,
   FQN="clang::TypeLoc::isKind", NM="_ZN5clang7TypeLoc6isKindERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLoc6isKindERKS0_")
  //</editor-fold>
  /*friend*//*private*/ static boolean isKind(final /*const*/ TypeLoc /*&*/ $Prm0) {
    return true;
  }

  
  
  /// \brief Initializes a type location, and all of its children
  /// recursively, as if the entire tree had been written in the
  /// given location.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::initializeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 112,
   FQN="clang::TypeLoc::initializeImpl", NM="_ZN5clang7TypeLoc14initializeImplERNS_10ASTContextES0_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLoc14initializeImplERNS_10ASTContextES0_NS_14SourceLocationE")
  //</editor-fold>
  private static void initializeImpl(final ASTContext /*&*/ Context, TypeLoc TL, 
                SourceLocation Loc) {
    while (true) {
      switch (TL.getTypeLocClass()) {
       case Qualified:
        {
          QualifiedTypeLoc TLCasted = TL.castAs(QualifiedTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Builtin:
        {
          BuiltinTypeLoc TLCasted = TL.castAs(BuiltinTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Complex:
        {
          ComplexTypeLoc TLCasted = TL.castAs(ComplexTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Pointer:
        {
          PointerTypeLoc TLCasted = TL.castAs(PointerTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case BlockPointer:
        {
          BlockPointerTypeLoc TLCasted = TL.castAs(BlockPointerTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case LValueReference:
        {
          LValueReferenceTypeLoc TLCasted = TL.castAs(LValueReferenceTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case RValueReference:
        {
          RValueReferenceTypeLoc TLCasted = TL.castAs(RValueReferenceTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case MemberPointer:
        {
          MemberPointerTypeLoc TLCasted = TL.castAs(MemberPointerTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case ConstantArray:
        {
          ConstantArrayTypeLoc TLCasted = TL.castAs(ConstantArrayTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case IncompleteArray:
        {
          IncompleteArrayTypeLoc TLCasted = TL.castAs(IncompleteArrayTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case VariableArray:
        {
          VariableArrayTypeLoc TLCasted = TL.castAs(VariableArrayTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case DependentSizedArray:
        {
          DependentSizedArrayTypeLoc TLCasted = TL.castAs(DependentSizedArrayTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case DependentSizedExtVector:
        {
          DependentSizedExtVectorTypeLoc TLCasted = TL.castAs(DependentSizedExtVectorTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Vector:
        {
          VectorTypeLoc TLCasted = TL.castAs(VectorTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case ExtVector:
        {
          ExtVectorTypeLoc TLCasted = TL.castAs(ExtVectorTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case FunctionProto:
        {
          FunctionProtoTypeLoc TLCasted = TL.castAs(FunctionProtoTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case FunctionNoProto:
        {
          FunctionNoProtoTypeLoc TLCasted = TL.castAs(FunctionNoProtoTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case UnresolvedUsing:
        {
          UnresolvedUsingTypeLoc TLCasted = TL.castAs(UnresolvedUsingTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Paren:
        {
          ParenTypeLoc TLCasted = TL.castAs(ParenTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Typedef:
        {
          TypedefTypeLoc TLCasted = TL.castAs(TypedefTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Adjusted:
        {
          AdjustedTypeLoc TLCasted = TL.castAs(AdjustedTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Decayed:
        {
          DecayedTypeLoc TLCasted = TL.castAs(DecayedTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case TypeOfExpr:
        {
          TypeOfExprTypeLoc TLCasted = TL.castAs(TypeOfExprTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case TypeOf:
        {
          TypeOfTypeLoc TLCasted = TL.castAs(TypeOfTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Decltype:
        {
          DecltypeTypeLoc TLCasted = TL.castAs(DecltypeTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case UnaryTransform:
        {
          UnaryTransformTypeLoc TLCasted = TL.castAs(UnaryTransformTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Record:
        {
          RecordTypeLoc TLCasted = TL.castAs(RecordTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Enum:
        {
          EnumTypeLoc TLCasted = TL.castAs(EnumTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Elaborated:
        {
          ElaboratedTypeLoc TLCasted = TL.castAs(ElaboratedTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Attributed:
        {
          AttributedTypeLoc TLCasted = TL.castAs(AttributedTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case TemplateTypeParm:
        {
          TemplateTypeParmTypeLoc TLCasted = TL.castAs(TemplateTypeParmTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case SubstTemplateTypeParm:
        {
          SubstTemplateTypeParmTypeLoc TLCasted = TL.castAs(SubstTemplateTypeParmTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case SubstTemplateTypeParmPack:
        {
          SubstTemplateTypeParmPackTypeLoc TLCasted = TL.castAs(SubstTemplateTypeParmPackTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case TemplateSpecialization:
        {
          TemplateSpecializationTypeLoc TLCasted = TL.castAs(TemplateSpecializationTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Auto:
        {
          AutoTypeLoc TLCasted = TL.castAs(AutoTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case InjectedClassName:
        {
          InjectedClassNameTypeLoc TLCasted = TL.castAs(InjectedClassNameTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case DependentName:
        {
          DependentNameTypeLoc TLCasted = TL.castAs(DependentNameTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case DependentTemplateSpecialization:
        {
          DependentTemplateSpecializationTypeLoc TLCasted = TL.castAs(DependentTemplateSpecializationTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case PackExpansion:
        {
          PackExpansionTypeLoc TLCasted = TL.castAs(PackExpansionTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case ObjCObject:
        {
          ObjCObjectTypeLoc TLCasted = TL.castAs(ObjCObjectTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case ObjCInterface:
        {
          ObjCInterfaceTypeLoc TLCasted = TL.castAs(ObjCInterfaceTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case ObjCObjectPointer:
        {
          ObjCObjectPointerTypeLoc TLCasted = TL.castAs(ObjCObjectPointerTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Pipe:
        {
          PipeTypeLoc TLCasted = TL.castAs(PipeTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
       case Atomic:
        {
          AtomicTypeLoc TLCasted = TL.castAs(AtomicTypeLoc.class);
          TLCasted.initializeLocal(Context, new SourceLocation(Loc));
          TL.$assignMove(TLCasted.getNextTypeLoc());
          if (!TL.$bool()) {
            return;
          }
          continue;
        }
      }
    }
  }

  
  /// \brief Get the next TypeLoc pointed by this TypeLoc, e.g for "int*" the
  /// TypeLoc is a PointerLoc and next TypeLoc is for "int".
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getNextTypeLocImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 105,
   FQN="clang::TypeLoc::getNextTypeLocImpl", NM="_ZN5clang7TypeLoc18getNextTypeLocImplES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLoc18getNextTypeLocImplES0_")
  //</editor-fold>
  private static TypeLoc getNextTypeLocImpl(TypeLoc TL) {
    return new NextLoc().Visit(TL);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::IgnoreParensImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 354,
   FQN="clang::TypeLoc::IgnoreParensImpl", NM="_ZN5clang7TypeLoc16IgnoreParensImplES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLoc16IgnoreParensImplES0_")
  //</editor-fold>
  private static TypeLoc IgnoreParensImpl(TypeLoc TL) {
    {
      ParenTypeLoc PTL;
      while ((PTL = TL.getAs(ParenTypeLoc.class)).$bool()) {
        TL.$assignMove(PTL.getInnerLoc());
      }
    }
    return new TypeLoc(JD$Move.INSTANCE, TL);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::getLocalSourceRangeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 40,
   FQN="clang::TypeLoc::getLocalSourceRangeImpl", NM="_ZN5clang7TypeLoc23getLocalSourceRangeImplES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLoc23getLocalSourceRangeImplES0_")
  //</editor-fold>
  private static SourceRange getLocalSourceRangeImpl(TypeLoc TL) {
    if (TL.isNull()) {
      return new SourceRange();
    }
    return new TypeLocRanger().Visit(new TypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*final*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 40,
   FQN="clang::TypeLoc::operator=", NM="_ZN5clang7TypeLocaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLocaSERKS0_")
  //</editor-fold>
  public final /*inline*/ TypeLoc /*&*/ $assign(final /*const*/ TypeLoc /*&*/ $Prm0) {
    this.Ty = $Prm0.Ty;
    this.Data = $Prm0.Data;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*final and clear input*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 40,
   FQN="clang::TypeLoc::operator=", NM="_ZN5clang7TypeLocaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLocaSEOS0_")
  //</editor-fold>
  public final /*inline*/ TypeLoc /*&*/ $assignMove(final TypeLoc /*&&*/$Prm0) {
    assert this != $Prm0;
    this.Ty = $Prm0.Ty;
    this.Data = $Prm0.Data;
    $Prm0.Ty = null;
    $Prm0.Data = null;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::TypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 40,
   FQN="clang::TypeLoc::TypeLoc", NM="_ZN5clang7TypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TypeLoc(final /*const*/ TypeLoc /*&*/ $Prm0) {
    // : Ty(.Ty), Data(.Data) 
    //START JInit
    this.Ty = $Prm0.Ty;
    this.Data = $Prm0.Data;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLoc::TypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clear input*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 40,
   FQN="clang::TypeLoc::TypeLoc", NM="_ZN5clang7TypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang7TypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ TypeLoc(JD$Move _dparam, final TypeLoc /*&&*/$Prm0) {
    // : Ty(static_cast<TypeLoc &&>().Ty), Data(static_cast<TypeLoc &&>().Data) 
    //START JInit
    this.Ty = $Prm0.Ty;
    this.Data = $Prm0.Data;
    //END JInit
    $Prm0.Ty = null;
    $Prm0.Data = null;    
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public TypeLoc clone() {
    assert getClass() == TypeLoc.class : "Forgot to implement clone in class " + getClass().getCanonicalName() + "?";
    return new TypeLoc(this);
  }

  public static int javaPrepareMemory(QualType T, type$ptr<?> TypeLoc$Data) {
    return javaPrepareMemory(T, TypeLoc$Data, Integer.MAX_VALUE);
  }
  public static int javaPrepareMemory(QualType T, type$ptr<?> TypeLoc$Data, int MaxSizeToInitialize) {
    // TODO: when create TypeSourceInfo, we need a TypeLoc-visitor to initialize all Local/ExtraLocal data of TypeLocs
    TypeLoc TL = new TypeLoc(T, TypeLoc$Data);
    int Total = 0;
    while (TL.$bool() && (Total < MaxSizeToInitialize)) {
      TL = TypeLocToJavaDerived.toJavaDerived(TL);
      assert !TL.isNull();
      assert TL.Data != null;
      int size = TL.javaAllocateLocalData();
      assert size == TL.getLocalDataSize() : TL.getClass().getSimpleName() + " allocate must init exactly the same count as getFullDataSize:" + size + " vs. " + TL.getFullDataSize();
      Total += size;
      TL = TL.getNextTypeLoc();
    } 
    return Total;
  }
  
  protected int javaAllocateLocalData() {
    throw new UnsupportedOperationException("Should be overridden in descendant usually based on getLocalDataSize/initializeLocal: " + getClass().getName());
  }
  
  public /*uint*/int getLocalDataSize() /*const*/ {
    throw new UnsupportedOperationException("Should be overridden in descendant " + getClass().getName());
  }

  public /*uint*/int getLocalDataAlignment() /*const*/ {
    throw new UnsupportedOperationException("Should be overridden in descendant " + getClass().getName());
  }

  /*friend*//*private*/ static boolean isKind(Class<? extends TypeLoc> TypeLocClazz, /*const*/ TypeLoc /*&*/ TL) {
    if (TypeLocClazz == TypeLoc.class) {
      // copied from TypeLoc
      return true;
    } else if (TypeLocClazz == QualifiedTypeLoc.class) {
      // copied from QualifiedTypeLoc.isKind
      return TL.getType().hasLocalQualifiers();
    } else if (TypeLocClazz == UnqualTypeLoc.class) {
      // copied from UnqualTypeLoc
      return !TL.getType().hasLocalQualifiers();
    }
    assert Concrete$UnqualTypeLoc.class.isAssignableFrom(TypeLocClazz) : "unexpected class derived directly form TypeLoc? " + TypeLocClazz;
    if (TypeLocClazz == TypeSpecTypeLoc.class) {
      // copied from TypeSpecTypeLoc
      if (TL.getType().hasLocalQualifiers()) {
        return false;
      }    
      return new TSTChecker().Visit(TL);
    }
    assert !(TL instanceof UnqualTypeLoc) || !TL.getType().hasLocalQualifiers() : "UnqualTypeLoc should not have local qualifiers: " + TL;
    if (TL instanceof UnqualTypeLoc) {
      // we can skip TL.getType().hasLocalQualifiers() check,
      // clang::InheritingConcreteTypeLoc::isKind(UnqualTypeLoc TL) doesn't check the Qualifiers
      return classofType(TypeLocClazz, TL);
    } else {
      // The check is copied from clang::ConcreteTypeLoc::isKind(TypeLoc TL)
      if (TL.getType().hasLocalQualifiers()) {
        return false;
      }      
      return classofType(TypeLocClazz, TL);
    }
    // clang::InheritingConcreteTypeLoc::isKind(UnqualTypeLoc TL) doesn't check the Qualifiers
//    if (TL instanceof UnqualTypeLoc && 
//            org.clang.ast.java.InheritingConcreteTypeLocBase.class.isAssignableFrom(TypeLocClazz)) {
//      // copied from clang::InheritingConcreteTypeLoc::isKind(UnqualTypeLoc TL)
//      return classofType(TypeLocClazz, TL);
//    }
//    // The check is copied from clang::ConcreteTypeLoc::isKind(TypeLoc TL)
//    if (TL.getType().hasLocalQualifiers()) {
//      return false;
//    }
  }
  /*friend*//*private*/ static <T extends TypeLoc> boolean classofType(Class<T> TypeLocClass, /*const*/ TypeLoc /*&*/ TL) {
    // known classofType have implementation:
    //return TypeClass::classof(Ty);
    BoolPredicate<Type> TypeClassOf = TypeLocToTypeClassof(TypeLocClass);
    /*FIXME*/return TypeClassOf.$call(TL.getTypePtr());
  }

  /*friend*//*private*/ static Class<? extends Type> TypeLocToTypeClass(Class<? extends TypeLoc> TypeLocClass) {
    assert TypeLocToType.get(TypeLocClass) != null : "no Type-class for TypeLoc-class " + TypeLocClass;
    return TypeLocToType.get(TypeLocClass);
  }

  /*friend*//*private*/ static BoolPredicate<Type> TypeLocToTypeClassof(Class<? extends TypeLoc> TypeLocClass) {
    assert TypeLocToTypeClassof.get(TypeLocClass) != null : "no Type-classof for TypeLoc-class " + TypeLocClass;
    return TypeLocToTypeClassof.get(TypeLocClass);
  }

  /*friend*//*private*/ static <TLoc extends TypeLoc> TLoc TypeLocToTypeLocInstance(Class<? extends TypeLoc> TypeLocClass) {
    assert TypeLocToTypeLocConstructor.get(TypeLocClass) != null : "no TypeLoc-constructor for TypeLoc-class " + TypeLocClass;
    return (TLoc)TypeLocToTypeLocConstructor.get(TypeLocClass).$call();
  }

  /*friend*//*private*/ static Class<? extends TypeLoc> TypeToTypeLocClass(Class<? extends Type> TypeClass) {
    assert TypeToTypeLoc.get(TypeClass) != null : "no TypeLoc-class for Type-class " + TypeClass;
    return TypeToTypeLoc.get(TypeClass);
  }

  private static final java.util.Map<Class<? extends TypeLoc>, ConstructorCallback<? extends TypeLoc>> TypeLocToTypeLocConstructor = new java.util.HashMap<>(64);
  private static final java.util.Map<Class<? extends TypeLoc>, Class<? extends Type>> TypeLocToType = new java.util.HashMap<>(64);
  private static final java.util.Map<Class<? extends Type>, Class<? extends TypeLoc>> TypeToTypeLoc = new java.util.HashMap<>(64);
  private static final java.util.Map<Class<? extends TypeLoc>, BoolPredicate<Type>> TypeLocToTypeClassof = new java.util.HashMap<>(64);
  static <TLoc extends TypeLoc, Tp extends Type> void mapTypeLocToTypeClass(Class<TLoc> TypeLocClass, ConstructorCallback<TLoc> ctr, Class<Tp> TypeClass, BoolPredicate<Type> classof) {
    assert TypeLocClass != null;
    assert isSpecilTypeLocClass(TypeLocClass) || TypeClass != null : "not specified TypeClass for " + TypeLocClass;
    assert isSpecilTypeLocClass(TypeLocClass) || 
            TypeLocClass.getSimpleName().equals(TypeClass.getSimpleName() + "Loc") :  TypeLocClass.getSimpleName() + " vs. " + TypeClass.getSimpleName();
    assert TypeLocToTypeLocConstructor.get(TypeLocClass) == null : "constructor can not be registered twice [" + TypeLocClass + "] " + ctr + " vs. " + TypeLocToTypeLocConstructor.get(TypeLocClass);
    assert TypeLocToType.get(TypeLocClass) == null : "can not be registered twice [" + TypeLocClass + "] " + TypeClass + " vs. " + TypeLocToType.get(TypeLocClass);
    assert TypeToTypeLoc.get(TypeClass) == null : "can not be registered twice [" + TypeClass + "] " + TypeLocClass + " vs. " + TypeToTypeLoc.get(TypeLocClass);
    assert TypeLocToTypeClassof.get(TypeLocClass) == null : "can not be registered twice [" + TypeLocClass + "] vs. " + TypeLocToTypeClassof.get(TypeLocClass);
    TypeLocToTypeLocConstructor.put(TypeLocClass, ctr);
    TypeLocToType.put(TypeLocClass, TypeClass);
    if (TypeClass != null) {
      TypeToTypeLoc.put(TypeClass, TypeLocClass);
    } else {
      assert isSpecilTypeLocClass(TypeLocClass) : "not special class with null TypeClass " + TypeLocClass;
    }
    if (classof != null) {
      TypeLocToTypeClassof.put(TypeLocClass, classof);
    } else {
      assert isSpecilTypeLocClass(TypeLocClass) : "not special class with null classof predicate " + TypeLocClass;;
    }
  }
  
  // special classes
  static {  TypeLoc.mapTypeLocToTypeClass(TypeLoc.class, TypeLoc::new, null, null); }
  static {  TypeLoc.mapTypeLocToTypeClass(QualifiedTypeLoc.class, QualifiedTypeLoc::new, null, null); }
  static {  TypeLoc.mapTypeLocToTypeClass(UnqualTypeLoc.class, UnqualTypeLoc::new, null, null); }
  static {  TypeLoc.mapTypeLocToTypeClass(TypeSpecTypeLoc.class, TypeSpecTypeLoc::new, null, null); }
  // real classes
  static {  TypeLoc.mapTypeLocToTypeClass(AdjustedTypeLoc.class, AdjustedTypeLoc::new, AdjustedType.class, AdjustedType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(ArrayTypeLoc.class, ArrayTypeLoc::new, ArrayType.class, ArrayType::classof); }  
  static {  TypeLoc.mapTypeLocToTypeClass(AtomicTypeLoc.class, AtomicTypeLoc::new, AtomicType.class, AtomicType::classof); }  
  static {  TypeLoc.mapTypeLocToTypeClass(AttributedTypeLoc.class, AttributedTypeLoc::new, AttributedType.class, AttributedType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(AutoTypeLoc.class, AutoTypeLoc::new, AutoType.class, AutoType::classof); }  
  static {  TypeLoc.mapTypeLocToTypeClass(BlockPointerTypeLoc.class, BlockPointerTypeLoc::new, BlockPointerType.class, BlockPointerType::classof); }  
  static {  TypeLoc.mapTypeLocToTypeClass(BuiltinTypeLoc.class, BuiltinTypeLoc::new, BuiltinType.class, BuiltinType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(ComplexTypeLoc.class, ComplexTypeLoc::new, ComplexType.class, ComplexType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(ConstantArrayTypeLoc.class, ConstantArrayTypeLoc::new, ConstantArrayType.class, ConstantArrayType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(DecayedTypeLoc.class, DecayedTypeLoc::new, DecayedType.class, DecayedType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(DecltypeTypeLoc.class, DecltypeTypeLoc::new, DecltypeType.class, DecltypeType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(DependentNameTypeLoc.class, DependentNameTypeLoc::new, DependentNameType.class, DependentNameType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(DependentSizedArrayTypeLoc.class, DependentSizedArrayTypeLoc::new, DependentSizedArrayType.class, DependentSizedArrayType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(DependentSizedExtVectorTypeLoc.class, DependentSizedExtVectorTypeLoc::new, DependentSizedExtVectorType.class, DependentSizedExtVectorType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(DependentTemplateSpecializationTypeLoc.class, DependentTemplateSpecializationTypeLoc::new, DependentTemplateSpecializationType.class, DependentTemplateSpecializationType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(ElaboratedTypeLoc.class, ElaboratedTypeLoc::new, ElaboratedType.class, ElaboratedType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(EnumTypeLoc.class, EnumTypeLoc::new, EnumType.class, EnumType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(ExtVectorTypeLoc.class, ExtVectorTypeLoc::new, ExtVectorType.class, ExtVectorType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(FunctionNoProtoTypeLoc.class, FunctionNoProtoTypeLoc::new, FunctionNoProtoType.class, FunctionNoProtoType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(FunctionProtoTypeLoc.class, FunctionProtoTypeLoc::new, FunctionProtoType.class, FunctionProtoType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(FunctionTypeLoc.class, FunctionTypeLoc::new, FunctionType.class, FunctionType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(IncompleteArrayTypeLoc.class, IncompleteArrayTypeLoc::new, IncompleteArrayType.class, IncompleteArrayType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(LValueReferenceTypeLoc.class, LValueReferenceTypeLoc::new, LValueReferenceType.class, LValueReferenceType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(MemberPointerTypeLoc.class, MemberPointerTypeLoc::new, MemberPointerType.class, MemberPointerType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(ObjCInterfaceTypeLoc.class, ObjCInterfaceTypeLoc::new, ObjCInterfaceType.class, ObjCInterfaceType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(ObjCObjectPointerTypeLoc.class, ObjCObjectPointerTypeLoc::new, ObjCObjectPointerType.class, ObjCObjectPointerType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(ObjCObjectTypeLoc.class, ObjCObjectTypeLoc::new, ObjCObjectType.class, ObjCObjectType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(PackExpansionTypeLoc.class, PackExpansionTypeLoc::new, PackExpansionType.class, PackExpansionType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(ParenTypeLoc.class, ParenTypeLoc::new, ParenType.class, ParenType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(PipeTypeLoc.class, PipeTypeLoc::new, PipeType.class, PipeType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(PointerTypeLoc.class, PointerTypeLoc::new, PointerType.class, PointerType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(RecordTypeLoc.class, RecordTypeLoc::new, RecordType.class, RecordType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(ReferenceTypeLoc.class, ReferenceTypeLoc::new, ReferenceType.class, ReferenceType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(RValueReferenceTypeLoc.class, RValueReferenceTypeLoc::new, RValueReferenceType.class, RValueReferenceType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(SubstTemplateTypeParmPackTypeLoc.class, SubstTemplateTypeParmPackTypeLoc::new, SubstTemplateTypeParmPackType.class, SubstTemplateTypeParmPackType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(SubstTemplateTypeParmTypeLoc.class, SubstTemplateTypeParmTypeLoc::new, SubstTemplateTypeParmType.class, SubstTemplateTypeParmType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(TagTypeLoc.class, TagTypeLoc::new, TagType.class, TagType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(TemplateSpecializationTypeLoc.class, TemplateSpecializationTypeLoc::new, TemplateSpecializationType.class, TemplateSpecializationType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(TemplateTypeParmTypeLoc.class, TemplateTypeParmTypeLoc::new, TemplateTypeParmType.class, TemplateTypeParmType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(TypedefTypeLoc.class, TypedefTypeLoc::new, TypedefType.class, TypedefType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(TypeOfExprTypeLoc.class, TypeOfExprTypeLoc::new, TypeOfExprType.class, TypeOfExprType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(TypeOfTypeLoc.class, TypeOfTypeLoc::new, TypeOfType.class, TypeOfType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(UnaryTransformTypeLoc.class, UnaryTransformTypeLoc::new, UnaryTransformType.class, UnaryTransformType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(UnresolvedUsingTypeLoc.class, UnresolvedUsingTypeLoc::new, UnresolvedUsingType.class, UnresolvedUsingType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(VariableArrayTypeLoc.class, VariableArrayTypeLoc::new, VariableArrayType.class, VariableArrayType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(VectorTypeLoc.class, VectorTypeLoc::new, VectorType.class, VectorType::classof); }
  static {  TypeLoc.mapTypeLocToTypeClass(InjectedClassNameTypeLoc.class, InjectedClassNameTypeLoc::new, InjectedClassNameType.class, InjectedClassNameType::classof); }
  
  private static <TLoc extends TypeLoc> boolean isSpecilTypeLocClass(Class<TLoc> TypeLocClass) {
    return TypeLocClass == QualifiedTypeLoc.class || TypeLocClass == UnqualTypeLoc.class || TypeLocClass == TypeLoc.class || TypeLocClass == TypeSpecTypeLoc.class;
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Ty=" + Ty // NOI18N
              + ", Data=" + Data; // NOI18N
  }
}
