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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.impl.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.impl.APValueStatics.GetApproxValue;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_APSInt$C;


/// APValue - This class implements a discriminated union of [uninitialized]
/// [APSInt] [APFloat], [Complex APSInt] [Complex APFloat], [Expr + Offset],
/// [Vector: N * APValue], [Array: N * APValue]
//<editor-fold defaultstate="collapsed" desc="clang::APValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 38,
 FQN="clang::APValue", NM="_ZN5clang7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueE")
//</editor-fold>
public class APValue implements LValueBase, NativeSwappable, NativeCloneable<APValue>, Destructors.ClassWithDestructor {
  /*typedef llvm::APSInt APSInt*/
//  public final class APSInt extends APSInt{ };
  /*typedef llvm::APFloat APFloat*/
//  public final class APFloat extends APFloat{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::ValueKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 42,
   FQN="clang::APValue::ValueKind", NM="_ZN5clang7APValue9ValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue9ValueKindE")
  //</editor-fold>
  public enum ValueKind implements Native.ComparableLower {
    Uninitialized(0),
    Int(Uninitialized.getValue() + 1),
    Float(Int.getValue() + 1),
    ComplexInt(Float.getValue() + 1),
    ComplexFloat(ComplexInt.getValue() + 1),
    LValue(ComplexFloat.getValue() + 1),
    Vector(LValue.getValue() + 1),
    Array(Vector.getValue() + 1),
    Struct(Array.getValue() + 1),
    Union(Struct.getValue() + 1),
    MemberPointer(Union.getValue() + 1),
    AddrLabelDiff(MemberPointer.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ValueKind valueOf(int val) {
      ValueKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ValueKind[] VALUES;
      private static final ValueKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ValueKind kind : ValueKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ValueKind[min < 0 ? (1-min) : 0];
        VALUES = new ValueKind[max >= 0 ? (1+max) : 0];
        for (ValueKind kind : ValueKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ValueKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ValueKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ValueKind)obj).value);}
    //</editor-fold>
  };
  /*typedef llvm::PointerUnion<const ValueDecl *, const Expr *> LValueBase*/
//  public final class LValueBase extends PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >{ };
  /*typedef llvm::PointerIntPair<const Decl *, 1, bool> BaseOrMemberType*/
//  public final class BaseOrMemberType extends PointerBoolPair</*const*/ Decl/*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::LValuePathEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 58,
   FQN="clang::APValue::LValuePathEntry", NM="_ZN5clang7APValue15LValuePathEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue15LValuePathEntryE")
  //</editor-fold>
  public static class/*union*/ LValuePathEntry implements NativeCloneable<LValuePathEntry> {
    /// BaseOrMember - The FieldDecl or CXXRecordDecl indicating the next item
    /// in the path. An opaque value of type BaseOrMemberType.
    public Object/*void P*/ BaseOrMember;
    /// ArrayIndex - The array index of the next item in the path.
    public long/*uint64_t*/ ArrayIndex;
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::LValuePathEntry::LValuePathEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 58,
     FQN="clang::APValue::LValuePathEntry::LValuePathEntry", NM="_ZN5clang7APValue15LValuePathEntryC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue15LValuePathEntryC1Ev")
    //</editor-fold>
    public /*inline*/ LValuePathEntry() {
    }


    //<editor-fold defaultstate="collapsed" desc="clang::APValue::LValuePathEntry::LValuePathEntry">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 58,
     FQN="clang::APValue::LValuePathEntry::LValuePathEntry", NM="_ZN5clang7APValue15LValuePathEntryC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN5clang7APValue15LValuePathEntryC1ERKS1_")
    //</editor-fold>
    public /*inline*/ LValuePathEntry(final /*const*/ LValuePathEntry /*&*/ $Prm0) {
      this.BaseOrMember = $Prm0.BaseOrMember;
      this.ArrayIndex = $Prm0.ArrayIndex;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::APValue::LValuePathEntry::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 58,
     FQN="clang::APValue::LValuePathEntry::operator=", NM="_ZN5clang7APValue15LValuePathEntryaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN5clang7APValue15LValuePathEntryaSERKS1_")
    //</editor-fold>
    public /*inline*/ LValuePathEntry /*&*/ $assign(final /*const*/ LValuePathEntry /*&*/ $Prm0) {
      this.BaseOrMember = $Prm0.BaseOrMember;
      this.ArrayIndex = $Prm0.ArrayIndex;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    @Override public LValuePathEntry clone() { return new LValuePathEntry(this); }
    
    public static int/*uint*/ $sizeof_LValuePathEntry() {return 1;}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "BaseOrMember=" + BaseOrMember // NOI18N
                + ", ArrayIndex=" + ArrayIndex; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::NoLValuePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 65,
   FQN="clang::APValue::NoLValuePath", NM="_ZN5clang7APValue12NoLValuePathE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue12NoLValuePathE")
  //</editor-fold>
  public static class/*struct*/ NoLValuePath {
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::NoLValuePath::NoLValuePath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 65,
     FQN="clang::APValue::NoLValuePath::NoLValuePath", NM="_ZN5clang7APValue12NoLValuePathC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue12NoLValuePathC1ERKS1_")
    //</editor-fold>
    public /*inline*/ NoLValuePath(final /*const*/ NoLValuePath /*&*/ $Prm0) {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::NoLValuePath::NoLValuePath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 65,
     FQN="clang::APValue::NoLValuePath::NoLValuePath", NM="_ZN5clang7APValue12NoLValuePathC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue12NoLValuePathC1EOS1_")
    //</editor-fold>
    public /*inline*/ NoLValuePath(JD$Move _dparam, final NoLValuePath /*&&*/$Prm0) {
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    public NoLValuePath() {}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::UninitArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 66,
   FQN="clang::APValue::UninitArray", NM="_ZN5clang7APValue11UninitArrayE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue11UninitArrayE")
  //</editor-fold>
  public static class/*struct*/ UninitArray {

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::UninitArray::UninitArray">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 66,
     FQN="clang::APValue::UninitArray::UninitArray", NM="_ZN5clang7APValue11UninitArrayC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN5clang7APValue11UninitArrayC1EOS1_")
    //</editor-fold>
    public /*inline*/ UninitArray(JD$Move _dparam, final UninitArray /*&&*/$Prm0) {
    }


    //<editor-fold defaultstate="collapsed" desc="clang::APValue::UninitArray::~UninitArray">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 66,
     FQN="clang::APValue::UninitArray::~UninitArray", NM="_ZN5clang7APValue11UninitArrayD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN5clang7APValue11UninitArrayD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    public UninitArray() {}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::UninitStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 67,
   FQN="clang::APValue::UninitStruct", NM="_ZN5clang7APValue12UninitStructE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue12UninitStructE")
  //</editor-fold>
  public static class/*struct*/ UninitStruct {

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::UninitStruct::UninitStruct">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 67,
     FQN="clang::APValue::UninitStruct::UninitStruct", NM="_ZN5clang7APValue12UninitStructC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN5clang7APValue12UninitStructC1EOS1_")
    //</editor-fold>
    public /*inline*/ UninitStruct(JD$Move _dparam, final UninitStruct /*&&*/$Prm0) {
    }


    //<editor-fold defaultstate="collapsed" desc="clang::APValue::UninitStruct::~UninitStruct">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 67,
     FQN="clang::APValue::UninitStruct::~UninitStruct", NM="_ZN5clang7APValue12UninitStructD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN5clang7APValue12UninitStructD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    public UninitStruct() {}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
/*private:*/
  private ValueKind Kind;
  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::ComplexAPSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 71,
   FQN="clang::APValue::ComplexAPSInt", NM="_ZN5clang7APValue13ComplexAPSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue13ComplexAPSIntE")
  //</editor-fold>
  private static class/*struct*/ ComplexAPSInt implements Destructors.ClassWithDestructor {
    public APSInt Real;
    public APSInt Imag;
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::ComplexAPSInt::ComplexAPSInt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 73,
     FQN="clang::APValue::ComplexAPSInt::ComplexAPSInt", NM="_ZN5clang7APValue13ComplexAPSIntC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue13ComplexAPSIntC1Ev")
    //</editor-fold>
    public ComplexAPSInt() {
      // : Real(1), Imag(1) 
      //START JInit
      this.Real = new APSInt(1);
      this.Imag = new APSInt(1);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::ComplexAPSInt::~ComplexAPSInt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 71,
     FQN="clang::APValue::ComplexAPSInt::~ComplexAPSInt", NM="_ZN5clang7APValue13ComplexAPSIntD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue13ComplexAPSIntD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Imag.$destroy();
      Real.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Real=" + Real // NOI18N
                + ", Imag=" + Imag; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::ComplexAPFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 75,
   FQN="clang::APValue::ComplexAPFloat", NM="_ZN5clang7APValue14ComplexAPFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue14ComplexAPFloatE")
  //</editor-fold>
  private static class/*struct*/ ComplexAPFloat implements Destructors.ClassWithDestructor {
    public APFloat Real;
    public APFloat Imag;
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::ComplexAPFloat::ComplexAPFloat">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 77,
     FQN="clang::APValue::ComplexAPFloat::ComplexAPFloat", NM="_ZN5clang7APValue14ComplexAPFloatC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue14ComplexAPFloatC1Ev")
    //</editor-fold>
    public ComplexAPFloat() {
      // : Real(0.), Imag(0.) 
      //START JInit
      this.Real = new APFloat(0.);
      this.Imag = new APFloat(0.);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::ComplexAPFloat::~ComplexAPFloat">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 75,
     FQN="clang::APValue::ComplexAPFloat::~ComplexAPFloat", NM="_ZN5clang7APValue14ComplexAPFloatD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue14ComplexAPFloatD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Imag.$destroy();
      Real.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Real=" + Real // NOI18N
                + ", Imag=" + Imag; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::LV">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 35,
   FQN="clang::APValue::LV", NM="_ZN5clang7APValue2LVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue2LVE")
  //</editor-fold>
  private static class/*struct*/ LV extends /**/ LVBase implements Destructors.ClassWithDestructor {
    public static /*const*//*uint*/int InlinePathSpace = $div_uint((DataSize - $sizeof_LVBase()), LValuePathEntry.$sizeof_LValuePathEntry());
    
    /// Path - The sequence of base classes, fields and array indices to follow to
    /// walk from Base to the subobject. When performing GCC-style folding, there
    /// may not be such a path.
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::LV::(anonymous)">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 42,
     FQN="clang::APValue::LV::(anonymous)", NM="_ZN5clang7APValue2LVE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue2LVE_Unnamed_union1")
    //</editor-fold>
    public static class/*union*/ Unnamed_union1 {
      public LValuePathEntry Path[/*1*/] = new LValuePathEntry [1];
      public LValuePathEntry[] /*P*/ PathPtr;
      
      @Override public String toString() {
        return "" + "Path=" + Path // NOI18N
                  + ", PathPtr=" + PathPtr; // NOI18N
      }
    };
    public Unnamed_union1 Unnamed_field = new Unnamed_union1();
    
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::LV::LV">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 47,
     FQN="clang::APValue::LV::LV", NM="_ZN5clang7APValue2LVC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue2LVC1Ev")
    //</editor-fold>
    public LV() {
      // : LVBase() 
      //START JInit
      super();
      //END JInit
      PathLength = (/*uint*/int)-1;
    }
    
//<editor-fold defaultstate="collapsed" desc="clang::APValue::LV::~LV">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 48,
     FQN="clang::APValue::LV::~LV", NM="_ZN5clang7APValue2LVD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue2LVD0Ev")
    //</editor-fold>
    public void $destroy() {
      resizePath(0);
      super.$destroy();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::LV::resizePath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 50,
     FQN="clang::APValue::LV::resizePath", NM="_ZN5clang7APValue2LV10resizePathEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue2LV10resizePathEj")
    //</editor-fold>
    public void resizePath(/*uint*/int Length) {
      if (Length == PathLength) {
        return;
      }
      if (hasPathPtr()) {
        /*delete[]*/Destructors.$destroyArray(Unnamed_field.PathPtr);
      }
      PathLength = Length;
      if (hasPathPtr()) {
        Unnamed_field.PathPtr = new LValuePathEntry [Length];
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::LV::hasPath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 60,
     FQN="clang::APValue::LV::hasPath", NM="_ZNK5clang7APValue2LV7hasPathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue2LV7hasPathEv")
    //</editor-fold>
    public boolean hasPath() /*const*/ {
      return PathLength != (/*uint*/int)-1;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::LV::hasPathPtr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 61,
     FQN="clang::APValue::LV::hasPathPtr", NM="_ZNK5clang7APValue2LV10hasPathPtrEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue2LV10hasPathPtrEv")
    //</editor-fold>
    public boolean hasPathPtr() /*const*/ {
      return hasPath() && $greater_uint(PathLength, InlinePathSpace);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::LV::getPath">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 63,
     FQN="clang::APValue::LV::getPath", NM="_ZN5clang7APValue2LV7getPathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue2LV7getPathEv")
    //</editor-fold>
    public type$ptr<LValuePathEntry/*P*/> getPath() {
      return create_type$ptr(hasPathPtr() ? Unnamed_field.PathPtr : Unnamed_field.Path);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::LV::getPath">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 64,
     FQN="clang::APValue::LV::getPath", NM="_ZNK5clang7APValue2LV7getPathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue2LV7getPathEv")
    //</editor-fold>
    public /*const*/ type$ptr<LValuePathEntry/*P*/> getPath$Const() /*const*/ {
      return create_type$ptr(hasPathPtr() ? Unnamed_field.PathPtr : Unnamed_field.Path);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    public static int $sizeof_LV(){return 1;}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + super.toString(); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::Vec">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 80,
   FQN="clang::APValue::Vec", NM="_ZN5clang7APValue3VecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue3VecE")
  //</editor-fold>
  private static class/*struct*/ Vec implements Destructors.ClassWithDestructor {
    public APValue[] /*P*/ Elts;
    public /*uint*/int NumElts;
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::Vec::Vec">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 83,
     FQN="clang::APValue::Vec::Vec", NM="_ZN5clang7APValue3VecC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue3VecC1Ev")
    //</editor-fold>
    public Vec() {
      // : Elts(null), NumElts(0) 
      //START JInit
      this.Elts = null;
      this.NumElts = 0;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::Vec::~Vec">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 84,
     FQN="clang::APValue::Vec::~Vec", NM="_ZN5clang7APValue3VecD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue3VecD0Ev")
    //</editor-fold>
    public void $destroy() {
      /*delete[]*/Destructors.$destroyArray(Elts);
    }

    
    @Override public String toString() {
      return "" + "Elts=" + Elts // NOI18N
                + ", NumElts=" + NumElts; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::Arr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 86,
   FQN="clang::APValue::Arr", NM="_ZN5clang7APValue3ArrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue3ArrE")
  //</editor-fold>
  private static class/*struct*/ Arr implements Destructors.ClassWithDestructor {
    public APValue[] /*P*/ Elts;
    public /*uint*/int NumElts;
    public /*uint*/int ArrSize;
    
    // FIXME: Reduce the malloc traffic here.
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::Arr::Arr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 108,
     FQN="clang::APValue::Arr::Arr", NM="_ZN5clang7APValue3ArrC1Ejj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue3ArrC1Ejj")
    //</editor-fold>
    public Arr(/*uint*/int NumElts, /*uint*/int Size) {
      // : Elts(new APValue [NumElts + (NumElts != Size ? 1 : 0)]), NumElts(NumElts), ArrSize(Size) 
      //START JInit
      this.Elts = new$T(new APValue [NumElts + (NumElts != Size ? 1 : 0)], ()->new APValue());
      this.NumElts = NumElts;
      this.ArrSize = Size;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::Arr::~Arr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 111,
     FQN="clang::APValue::Arr::~Arr", NM="_ZN5clang7APValue3ArrD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue3ArrD0Ev")
    //</editor-fold>
    public void $destroy() {
      /*delete[]*/Destructors.$destroyArray(Elts);
    }

    
    @Override public String toString() {
      return "" + "Elts=" + Elts // NOI18N
                + ", NumElts=" + NumElts // NOI18N
                + ", ArrSize=" + ArrSize; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::StructData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 92,
   FQN="clang::APValue::StructData", NM="_ZN5clang7APValue10StructDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue10StructDataE")
  //</editor-fold>
  private static class/*struct*/ StructData implements Destructors.ClassWithDestructor {
    public APValue[] /*P*/ Elts;
    public /*uint*/int NumBases;
    public /*uint*/int NumFields;
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::StructData::StructData">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 113,
     FQN="clang::APValue::StructData::StructData", NM="_ZN5clang7APValue10StructDataC1Ejj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue10StructDataC1Ejj")
    //</editor-fold>
    public StructData(/*uint*/int NumBases, /*uint*/int NumFields) {
      // : Elts(new APValue [NumBases + NumFields]), NumBases(NumBases), NumFields(NumFields) 
      //START JInit
      this.Elts = new$T(new APValue [NumBases + NumFields], ()->new APValue());
      this.NumBases = NumBases;
      this.NumFields = NumFields;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::StructData::~StructData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 116,
     FQN="clang::APValue::StructData::~StructData", NM="_ZN5clang7APValue10StructDataD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue10StructDataD0Ev")
    //</editor-fold>
    public void $destroy() {
      /*delete[]*/Destructors.$destroyArray(Elts);
    }

    
    @Override public String toString() {
      return "" + "Elts=" + Elts // NOI18N
                + ", NumBases=" + NumBases // NOI18N
                + ", NumFields=" + NumFields; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::UnionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 99,
   FQN="clang::APValue::UnionData", NM="_ZN5clang7APValue9UnionDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue9UnionDataE")
  //</editor-fold>
  private static class/*struct*/ UnionData implements Destructors.ClassWithDestructor {
    public /*const*/ FieldDecl /*P*/ Field;
    public APValue /*P*/ Value;
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::UnionData::UnionData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 120,
     FQN="clang::APValue::UnionData::UnionData", NM="_ZN5clang7APValue9UnionDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue9UnionDataC1Ev")
    //</editor-fold>
    public UnionData() {
      // : Field(null), Value(new APValue) 
      //START JInit
      this.Field = null;
      this.Value = new APValue();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::UnionData::~UnionData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 121,
     FQN="clang::APValue::UnionData::~UnionData", NM="_ZN5clang7APValue9UnionDataD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue9UnionDataD0Ev")
    //</editor-fold>
    public void $destroy() {
      if (Value != null) { Value.$destroy();};
    }

    
    @Override public String toString() {
      return "" + "Field=" + Field // NOI18N
                + ", Value=" + Value; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::AddrLabelDiffData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 105,
   FQN="clang::APValue::AddrLabelDiffData", NM="_ZN5clang7APValue17AddrLabelDiffDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue17AddrLabelDiffDataE")
  //</editor-fold>
  private static class/*struct*/ AddrLabelDiffData implements Destructors.ClassWithDestructor {
    public /*const*/ AddrLabelExpr /*P*/ LHSExpr;
    public /*const*/ AddrLabelExpr /*P*/ RHSExpr;
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    @Override public void $destroy() {}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "LHSExpr=" + LHSExpr // NOI18N
                + ", RHSExpr=" + RHSExpr; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MemberPointerData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Make InlinePathSpace constant*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 76,
   FQN="clang::APValue::MemberPointerData", NM="_ZN5clang7APValue17MemberPointerDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue17MemberPointerDataE")
  //</editor-fold>
  private static class/*struct*/ MemberPointerData extends /**/ MemberPointerBase implements Destructors.ClassWithDestructor {
    public static final /*const*//*uint*/int InlinePathSpace = /*JAVA*/ 6; //$div_uint((DataSize - $sizeof_MemberPointerBase()), $sizeof_ptr(/* CXXRecordDecl  */));
    /*typedef const CXXRecordDecl *PathElem*/
//    public final class PathElem extends /*const*/ CXXRecordDecl /*P*/ { };
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::MemberPointerData::(anonymous)">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 80,
     FQN="clang::APValue::MemberPointerData::(anonymous)", NM="_ZN5clang7APValue17MemberPointerDataE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue17MemberPointerDataE_Unnamed_union1")
    //</editor-fold>
    public static class/*union*/ Unnamed_union1 {
      public type$ptr<CXXRecordDecl> Path = create_type$ptr(new$T(new /*const*/ CXXRecordDecl /*P*/  [InlinePathSpace], ()->null));//create_type$ptr(new$T(new /*const*/ CXXRecordDecl /*P*/  [InlinePathSpace], ()->new /*const*/ CXXRecordDecl /*P*/ ()));
      public type$ptr</*const*/ CXXRecordDecl /*P*/ /*P*/> PathPtr;
      
      @Override public String toString() {
        return "" + "Path=" + Path // NOI18N
                  + ", PathPtr=" + PathPtr; // NOI18N
      }
    };
    public Unnamed_union1 Unnamed_field = new Unnamed_union1();
    
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::MemberPointerData::MemberPointerData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 85,
     FQN="clang::APValue::MemberPointerData::MemberPointerData", NM="_ZN5clang7APValue17MemberPointerDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue17MemberPointerDataC1Ev")
    //</editor-fold>
    public MemberPointerData() {
      // : MemberPointerBase() 
      //START JInit
      super();
      //END JInit
      PathLength = 0;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::MemberPointerData::~MemberPointerData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 86,
     FQN="clang::APValue::MemberPointerData::~MemberPointerData", NM="_ZN5clang7APValue17MemberPointerDataD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue17MemberPointerDataD0Ev")
    //</editor-fold>
    public void $destroy() {
      resizePath(0);
      super.$destroy();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::MemberPointerData::resizePath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 88,
     FQN="clang::APValue::MemberPointerData::resizePath", NM="_ZN5clang7APValue17MemberPointerData10resizePathEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue17MemberPointerData10resizePathEj")
    //</editor-fold>
    public void resizePath(/*uint*/int Length) {
      if (Length == PathLength) {
        return;
      }
      if (hasPathPtr()) {
        /*delete[]*/Destructors.$destroyArray(Unnamed_field.PathPtr);
      }
      PathLength = Length;
      if (hasPathPtr()) {
        Unnamed_field.PathPtr = create_const_type$ptr(new /*const*/ CXXRecordDecl /*P*/ [Length]);
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::MemberPointerData::hasPathPtr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 98,
     FQN="clang::APValue::MemberPointerData::hasPathPtr", NM="_ZNK5clang7APValue17MemberPointerData10hasPathPtrEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue17MemberPointerData10hasPathPtrEv")
    //</editor-fold>
    public boolean hasPathPtr() /*const*/ {
      return $greater_uint(PathLength, InlinePathSpace);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::APValue::MemberPointerData::getPath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 100,
     FQN="clang::APValue::MemberPointerData::getPath", NM="_ZN5clang7APValue17MemberPointerData7getPathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue17MemberPointerData7getPathEv")
    //</editor-fold>
    public type$ptr</*const*/ CXXRecordDecl /*P*/ /*P*/> getPath() {
      return hasPathPtr() ? Unnamed_field.PathPtr : Unnamed_field.Path;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::APValue::MemberPointerData::getPath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 101,
     FQN="clang::APValue::MemberPointerData::getPath", NM="_ZNK5clang7APValue17MemberPointerData7getPathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue17MemberPointerData7getPathEv")
    //</editor-fold>
    public type$ptr</*const*/ CXXRecordDecl /*P*/ /*const*/ /*P*/> getPath$Const() /*const*/ {
      return hasPathPtr() ? Unnamed_field.PathPtr : Unnamed_field.Path;
    }

    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  // We ensure elsewhere that Data is big enough for LV and MemberPointerData.
  /*typedef llvm::AlignedCharArrayUnion<void *, APSInt, APFloat, ComplexAPSInt, ComplexAPFloat, Vec, Arr, StructData, UnionData, AddrLabelDiffData> DataType*/
//  public final class DataType extends APValue.DataType{ };
  private static /*const*//*size_t*/int DataSize = APValue.DataType.$sizeof_DataType();
  
  private APValue.DataType Data;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 120,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1Ev")
  //</editor-fold>
  public APValue() {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 121,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1EN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1EN4llvm6APSIntE")
  //</editor-fold>
  public /*explicit*/ APValue(APSInt I) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeInt();
    setInt(new APSInt(JD$Move.INSTANCE, std.move(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 124,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1EN4llvm7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1EN4llvm7APFloatE")
  //</editor-fold>
  public /*explicit*/ APValue(APFloat F) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeFloat();
    setFloat(new APFloat(JD$Move.INSTANCE, std.move(F)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 127,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1EPKS0_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1EPKS0_j")
  //</editor-fold>
  public /*explicit*/ APValue(/*const*/ type$ptr<APValue /*P*/> E, /*uint*/int N) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeVector();
    setVector(E, N);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 130,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1EN4llvm6APSIntES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1EN4llvm6APSIntES2_")
  //</editor-fold>
  public APValue(APSInt R, APSInt I) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeComplexInt();
    setComplexInt(new APSInt(JD$Move.INSTANCE, std.move(R)), new APSInt(JD$Move.INSTANCE, std.move(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 133,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1EN4llvm7APFloatES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1EN4llvm7APFloatES2_")
  //</editor-fold>
  public APValue(APFloat R, APFloat I) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeComplexFloat();
    setComplexFloat(new APFloat(JD$Move.INSTANCE, std.move(R)), new APFloat(JD$Move.INSTANCE, std.move(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 125,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1ERKS0_")
  //</editor-fold>
  public APValue(final /*const*/ APValue /*&*/ RHS) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    switch (RHS.getKind()) {
     case Uninitialized:
      break;
     case Int:
      MakeInt();
      setInt(new APSInt(RHS.getInt$Const()));
      break;
     case Float:
      MakeFloat();
      setFloat(new APFloat(RHS.getFloat$Const()));
      break;
     case Vector:
      MakeVector();
      setVector(create_type$ptr(((/*const*/ Vec /*P*/ )RHS.Data.buffer).Elts), 
          RHS.getVectorLength());
      break;
     case ComplexInt:
      MakeComplexInt();
      setComplexInt(new APSInt(RHS.getComplexIntReal$Const()), new APSInt(RHS.getComplexIntImag$Const()));
      break;
     case ComplexFloat:
      MakeComplexFloat();
      setComplexFloat(new APFloat(RHS.getComplexFloatReal$Const()), new APFloat(RHS.getComplexFloatImag$Const()));
      break;
     case LValue:
      MakeLValue();
      if (RHS.hasLValuePath()) {
        setLValue(RHS.getLValueBase(), RHS.getLValueOffset$Const(), RHS.getLValuePath(), 
            RHS.isLValueOnePastTheEnd(), RHS.getLValueCallIndex());
      } else {
        setLValue(RHS.getLValueBase(), RHS.getLValueOffset$Const(), new NoLValuePath(), 
            RHS.getLValueCallIndex());
      }
      break;
     case Array:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          MakeArray(RHS.getArrayInitializedElts(), RHS.getArraySize());
          for (/*uint*/int I = 0, N = RHS.getArrayInitializedElts(); I != N; ++I)  {
            $c$.clean(getArrayInitializedElt(I).$assign($c$.track(new APValue(RHS.getArrayInitializedElt$Const(I)))));
          }
          if (RHS.hasArrayFiller()) {
            $c$.clean(getArrayFiller().$assign($c$.track(new APValue(RHS.getArrayFiller$Const()))));
          }
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case Struct:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          MakeStruct(RHS.getStructNumBases(), RHS.getStructNumFields());
          for (/*uint*/int I = 0, N = RHS.getStructNumBases(); I != N; ++I)  {
            $c$.clean(getStructBase(I).$assign($c$.track(new APValue(RHS.getStructBase$Const(I)))));
          }
          for (/*uint*/int I = 0, N = RHS.getStructNumFields(); I != N; ++I)  {
            $c$.clean(getStructField(I).$assign($c$.track(new APValue(RHS.getStructField$Const(I)))));
          }
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case Union:
      MakeUnion();
      setUnion(RHS.getUnionField(), RHS.getUnionValue$Const());
      break;
     case MemberPointer:
      MakeMemberPointer(RHS.getMemberPointerDecl(), 
          RHS.isMemberPointerToDerivedMember(), 
          RHS.getMemberPointerPath());
      break;
     case AddrLabelDiff:
      MakeAddrLabelDiff();
      setAddrLabelDiff(RHS.getAddrLabelDiffLHS(), RHS.getAddrLabelDiffRHS());
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 137,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1EOS0_")
  //</editor-fold>
  public APValue(JD$Move _dparam, final APValue /*&&*/RHS) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    swap(RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 138,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1EN4llvm12PointerUnionIPKNS_9ValueDeclEPKNS_4ExprEEERKNS_9CharUnitsENS0_12NoLValuePathEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1EN4llvm12PointerUnionIPKNS_9ValueDeclEPKNS_4ExprEEERKNS_9CharUnitsENS0_12NoLValuePathEj")
  //</editor-fold>
  public APValue(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B, final /*const*/ CharUnits /*&*/ O, NoLValuePath N, /*uint*/int CallIndex) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeLValue();
    setLValue(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(B), O, new NoLValuePath(N), CallIndex);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 142,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1EN4llvm12PointerUnionIPKNS_9ValueDeclEPKNS_4ExprEEERKNS_9CharUnitsENS1_8ArrayRefINS0_15LValuePathEntryEEEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1EN4llvm12PointerUnionIPKNS_9ValueDeclEPKNS_4ExprEEERKNS_9CharUnitsENS1_8ArrayRefINS0_15LValuePathEntryEEEbj")
  //</editor-fold>
  public APValue(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B, final /*const*/ CharUnits /*&*/ O, ArrayRef<LValuePathEntry> Path, 
      boolean OnePastTheEnd, /*uint*/int CallIndex) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeLValue();
    setLValue(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(B), O, new ArrayRef<LValuePathEntry>(Path), OnePastTheEnd, CallIndex);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 147,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1ENS0_11UninitArrayEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1ENS0_11UninitArrayEjj")
  //</editor-fold>
  public APValue(UninitArray $Prm0, /*uint*/int InitElts, /*uint*/int Size) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeArray(InitElts, Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 150,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1ENS0_12UninitStructEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1ENS0_12UninitStructEjj")
  //</editor-fold>
  public APValue(UninitStruct $Prm0, /*uint*/int B, /*uint*/int M) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeStruct(B, M);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 153,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1EPKNS_9FieldDeclERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1EPKNS_9FieldDeclERKS0_")
  //</editor-fold>
  public /*explicit*/ APValue(/*const*/ FieldDecl /*P*/ D) {
    this(D, /*$c$.track(*/new APValue()/*)*/);
  }
  public /*explicit*/ APValue(/*const*/ FieldDecl /*P*/ D, final /*const*/ APValue /*&*/ V/*= APValue()*/) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeUnion();
    setUnion(D, V);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 157,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1EPKNS_9ValueDeclEbN4llvm8ArrayRefIPKNS_13CXXRecordDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1EPKNS_9ValueDeclEbN4llvm8ArrayRefIPKNS_13CXXRecordDeclEEE")
  //</editor-fold>
  public APValue(/*const*/ ValueDecl /*P*/ Member, boolean IsDerivedMember, 
      ArrayRef</*const*/ CXXRecordDecl /*P*/ > Path) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeMemberPointer(Member, IsDerivedMember, new ArrayRef</*const*/ CXXRecordDecl /*P*/ >(Path));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 161,
   FQN="clang::APValue::APValue", NM="_ZN5clang7APValueC1EPKNS_13AddrLabelExprES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueC1EPKNS_13AddrLabelExprES3_")
  //</editor-fold>
  public APValue(/*const*/ AddrLabelExpr /*P*/ LHSExpr, /*const*/ AddrLabelExpr /*P*/ RHSExpr) {
    // : Kind(Uninitialized), Data() 
    //START JInit
    this.Kind = ValueKind.Uninitialized;
    this.Data = new APValue.DataType();
    //END JInit
    MakeAddrLabelDiff();
    setAddrLabelDiff(LHSExpr, RHSExpr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::~APValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 166,
   FQN="clang::APValue::~APValue", NM="_ZN5clang7APValueD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueD0Ev")
  //</editor-fold>
  public void $destroy() {
    MakeUninit();
  }

  
  /// \brief Returns whether the object performed allocations.
  ///
  /// If APValues are constructed via placement new, \c needsCleanup()
  /// indicates whether the destructor must be called in order to correctly
  /// free all allocated memory.
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::needsCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 215,
   FQN="clang::APValue::needsCleanup", NM="_ZNK5clang7APValue12needsCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue12needsCleanupEv")
  //</editor-fold>
  public boolean needsCleanup() /*const*/ {
    switch (getKind()) {
     case Uninitialized:
     case AddrLabelDiff:
      return false;
     case Struct:
     case Union:
     case Array:
     case Vector:
      return true;
     case Int:
      return getInt$Const().needsCleanup();
     case Float:
      return getFloat$Const().needsCleanup();
     case ComplexFloat:
      assert (getComplexFloatImag$Const().needsCleanup() == getComplexFloatReal$Const().needsCleanup()) : "In _Complex float types, real and imaginary values always have the same size.";
      return getComplexFloatReal$Const().needsCleanup();
     case ComplexInt:
      assert (getComplexIntImag$Const().needsCleanup() == getComplexIntReal$Const().needsCleanup()) : "In _Complex int types, real and imaginary values must have the same size.";
      return getComplexIntReal$Const().needsCleanup();
     case LValue:
      return reinterpret_cast(/*const*/ LV /*P*/ .class, Data.buffer).hasPathPtr();
     case MemberPointer:
      return reinterpret_cast(/*const*/ MemberPointerData /*P*/ .class, Data.buffer).
          hasPathPtr();
    }
    throw new llvm_unreachable("Unknown APValue kind!");
  }

  
  /// \brief Swaps the contents of this and the given APValue.
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::swap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 250,
   FQN="clang::APValue::swap", NM="_ZN5clang7APValue4swapERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue4swapERS0_")
  //</editor-fold>
  public void swap(final APValue /*&*/ RHS) {
    //std.swap(Kind, RHS.Kind);
    ValueKind tmpKind = Kind;
    Kind = RHS.Kind;
    RHS.Kind = tmpKind;
    ///*char*/byte TmpData[/*32*/] = new$char(32);
    //memcpy(TmpData, Data.buffer, DataSize);
    //memcpy(Data.buffer, RHS.Data.buffer, DataSize);
    //memcpy(RHS.Data.buffer, TmpData, DataSize);
    Object tmpObject = Data.buffer;
    Data.buffer = RHS.Data.buffer;
    RHS.Data.buffer = tmpObject;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 180,
   FQN="clang::APValue::getKind", NM="_ZNK5clang7APValue7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue7getKindEv")
  //</editor-fold>
  public ValueKind getKind() /*const*/ {
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isUninit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 181,
   FQN="clang::APValue::isUninit", NM="_ZNK5clang7APValue8isUninitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue8isUninitEv")
  //</editor-fold>
  public boolean isUninit() /*const*/ {
    return Kind == ValueKind.Uninitialized;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 182,
   FQN="clang::APValue::isInt", NM="_ZNK5clang7APValue5isIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue5isIntEv")
  //</editor-fold>
  public boolean isInt() /*const*/ {
    return Kind == ValueKind.Int;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 183,
   FQN="clang::APValue::isFloat", NM="_ZNK5clang7APValue7isFloatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue7isFloatEv")
  //</editor-fold>
  public boolean isFloat() /*const*/ {
    return Kind == ValueKind.Float;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isComplexInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 184,
   FQN="clang::APValue::isComplexInt", NM="_ZNK5clang7APValue12isComplexIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue12isComplexIntEv")
  //</editor-fold>
  public boolean isComplexInt() /*const*/ {
    return Kind == ValueKind.ComplexInt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isComplexFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 185,
   FQN="clang::APValue::isComplexFloat", NM="_ZNK5clang7APValue14isComplexFloatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue14isComplexFloatEv")
  //</editor-fold>
  public boolean isComplexFloat() /*const*/ {
    return Kind == ValueKind.ComplexFloat;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 186,
   FQN="clang::APValue::isLValue", NM="_ZNK5clang7APValue8isLValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue8isLValueEv")
  //</editor-fold>
  public boolean isLValue() /*const*/ {
    return Kind == ValueKind.LValue;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 187,
   FQN="clang::APValue::isVector", NM="_ZNK5clang7APValue8isVectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue8isVectorEv")
  //</editor-fold>
  public boolean isVector() /*const*/ {
    return Kind == ValueKind.Vector;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 188,
   FQN="clang::APValue::isArray", NM="_ZNK5clang7APValue7isArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue7isArrayEv")
  //</editor-fold>
  public boolean isArray() /*const*/ {
    return Kind == ValueKind.Array;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 189,
   FQN="clang::APValue::isStruct", NM="_ZNK5clang7APValue8isStructEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue8isStructEv")
  //</editor-fold>
  public boolean isStruct() /*const*/ {
    return Kind == ValueKind.Struct;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isUnion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 190,
   FQN="clang::APValue::isUnion", NM="_ZNK5clang7APValue7isUnionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue7isUnionEv")
  //</editor-fold>
  public boolean isUnion() /*const*/ {
    return Kind == ValueKind.Union;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isMemberPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 191,
   FQN="clang::APValue::isMemberPointer", NM="_ZNK5clang7APValue15isMemberPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue15isMemberPointerEv")
  //</editor-fold>
  public boolean isMemberPointer() /*const*/ {
    return Kind == ValueKind.MemberPointer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isAddrLabelDiff">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 192,
   FQN="clang::APValue::isAddrLabelDiff", NM="_ZNK5clang7APValue15isAddrLabelDiffEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue15isAddrLabelDiffEv")
  //</editor-fold>
  public boolean isAddrLabelDiff() /*const*/ {
    return Kind == ValueKind.AddrLabelDiff;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 258,
   FQN="clang::APValue::dump", NM="_ZNK5clang7APValue4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump(llvm.errs());
    llvm.errs().$out_char($$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::dump">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 271,
   FQN="clang::APValue::dump", NM="_ZNK5clang7APValue4dumpERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue4dumpERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*/ {
    switch (getKind()) {
     case Uninitialized:
      OS.$out(/*KEEP_STR*/"Uninitialized");
      return;
     case Int:
      $out_raw_ostream_APSInt$C(OS.$out(/*KEEP_STR*/"Int: "), getInt$Const());
      return;
     case Float:
      OS.$out(/*KEEP_STR*/"Float: ").$out(GetApproxValue(getFloat$Const()));
      return;
     case Vector:
      OS.$out(/*KEEP_STR*/"Vector: ");
      getVectorElt$Const(0).dump(OS);
      for (/*uint*/int i = 1; i != getVectorLength(); ++i) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        getVectorElt$Const(i).dump(OS);
      }
      return;
     case ComplexInt:
      $out_raw_ostream_APSInt$C($out_raw_ostream_APSInt$C(OS.$out(/*KEEP_STR*/"ComplexInt: "), getComplexIntReal$Const()).$out(/*KEEP_STR*/$COMMA_SPACE), getComplexIntImag$Const());
      return;
     case ComplexFloat:
      OS.$out(/*KEEP_STR*/"ComplexFloat: ").$out(GetApproxValue(getComplexFloatReal$Const())).$out(
          /*KEEP_STR*/$COMMA_SPACE
      ).$out(GetApproxValue(getComplexFloatImag$Const()));
      return;
     case LValue:
      OS.$out(/*KEEP_STR*/"LValue: <todo>");
      return;
     case Array:
      OS.$out(/*KEEP_STR*/"Array: ");
      for (/*uint*/int I = 0, N = getArrayInitializedElts(); I != N; ++I) {
        getArrayInitializedElt$Const(I).dump(OS);
        if (I != getArraySize() - 1) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
      }
      if (hasArrayFiller()) {
        OS.$out_uint(getArraySize() - getArrayInitializedElts()).$out(/*KEEP_STR*/" x ");
        getArrayFiller$Const().dump(OS);
      }
      return;
     case Struct:
      OS.$out(/*KEEP_STR*/"Struct ");
      {
        /*uint*/int N = getStructNumBases();
        if ((N != 0)) {
          OS.$out(/*KEEP_STR*/" bases: ");
          getStructBase$Const(0).dump(OS);
          for (/*uint*/int I = 1; I != N; ++I) {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
            getStructBase$Const(I).dump(OS);
          }
        }
      }
      {
        /*uint*/int N = getStructNumFields();
        if ((N != 0)) {
          OS.$out(/*KEEP_STR*/" fields: ");
          getStructField$Const(0).dump(OS);
          for (/*uint*/int I = 1; I != N; ++I) {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
            getStructField$Const(I).dump(OS);
          }
        }
      }
      return;
     case Union:
      OS.$out(/*KEEP_STR*/"Union: ");
      getUnionValue$Const().dump(OS);
      return;
     case MemberPointer:
      OS.$out(/*KEEP_STR*/"MemberPointer: <todo>");
      return;
     case AddrLabelDiff:
      OS.$out(/*KEEP_STR*/"AddrLabelDiff: <todo>");
      return;
    }
    throw new llvm_unreachable("Unknown APValue kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::printPretty">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 344,
   FQN="clang::APValue::printPretty", NM="_ZNK5clang7APValue11printPrettyERN4llvm11raw_ostreamERNS_10ASTContextENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue11printPrettyERN4llvm11raw_ostreamERNS_10ASTContextENS_8QualTypeE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ Out, final ASTContext /*&*/ Ctx, QualType Ty) /*const*/ {
    switch (getKind()) {
     case Uninitialized:
      Out.$out(/*KEEP_STR*/"<uninitialized>");
      return;
     case Int:
      if (Ty.$arrow().isBooleanType()) {
        Out.$out((getInt$Const().getBoolValue() ? $true : $false));
      } else {
        $out_raw_ostream_APSInt$C(Out, getInt$Const());
      }
      return;
     case Float:
      Out.$out(GetApproxValue(getFloat$Const()));
      return;
     case Vector:
      {
        Out.$out_char($$LCURLY);
        QualType ElemTy = Ty.$arrow().getAs(VectorType.class).getElementType();
        getVectorElt$Const(0).printPretty(Out, Ctx, new QualType(ElemTy));
        for (/*uint*/int i = 1; i != getVectorLength(); ++i) {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
          getVectorElt$Const(i).printPretty(Out, Ctx, new QualType(ElemTy));
        }
        Out.$out_char($$RCURLY);
        return;
      }
     case ComplexInt:
      $out_raw_ostream_APSInt$C($out_raw_ostream_APSInt$C(Out, getComplexIntReal$Const()).$out(/*KEEP_STR*/$PLUS), getComplexIntImag$Const()).$out(/*KEEP_STR*/$i);
      return;
     case ComplexFloat:
      Out.$out(GetApproxValue(getComplexFloatReal$Const())).$out(/*KEEP_STR*/$PLUS).$out(
          GetApproxValue(getComplexFloatImag$Const())
      ).$out(/*KEEP_STR*/$i);
      return;
     case LValue:
      {
        PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > Base = getLValueBase();
        if (!Base.$bool()) {
          Out.$out(/*KEEP_STR*/$0);
          return;
        }
        
        boolean IsReference = Ty.$arrow().isReferenceType();
        QualType InnerTy = IsReference ? Ty.getNonReferenceType() : Ty.$arrow().getPointeeType();
        if (InnerTy.isNull()) {
          InnerTy.$assign(Ty);
        }
        if (!hasLValuePath()) {
          // No lvalue path: just print the offset.
          CharUnits O = new CharUnits(getLValueOffset$Const());
          CharUnits S = Ctx.getTypeSizeInChars(/*NO_COPY*/InnerTy);
          if (!O.isZero()) {
            if (IsReference) {
              Out.$out(/*KEEP_STR*/"*(");
            }
            if ((O.$mod(S) != 0)) {
              Out.$out(/*KEEP_STR*/"(char*)");
              S.$assignMove(CharUnits.One());
            }
            Out.$out_char($$AMP);
          } else if (!IsReference) {
            Out.$out_char($$AMP);
          }
          {
            
            /*const*/ ValueDecl /*P*/ VD = Base.dyn_cast(/*const*/ ValueDecl /*P*/.class);
            if ((VD != null)) {
              $out_raw_ostream_NamedDecl$C(Out, $Deref(VD));
            } else {
              assert (Base.get(/*const*/ Expr /*P*/.class) != null) : "Expecting non-null Expr";
              Base.get(/*const*/ Expr /*P*/.class).printPretty(Out, (PrinterHelper /*P*/ )null, 
                  Ctx.getPrintingPolicy());
            }
          }
          if (!O.isZero()) {
            Out.$out(/*KEEP_STR*/" + ").$out_llong((O.$slash(S)));
            if (IsReference) {
              Out.$out_char($$RPAREN);
            }
          }
          return;
        }
        
        // We have an lvalue path. Print it out nicely.
        if (!IsReference) {
          Out.$out_char($$AMP);
        } else if (isLValueOnePastTheEnd()) {
          Out.$out(/*KEEP_STR*/"*(&");
        }
        
        QualType ElemTy/*J*/= new QualType();
        {
          /*const*/ ValueDecl /*P*/ VD = Base.dyn_cast(/*const*/ ValueDecl /*P*/.class);
          if ((VD != null)) {
            $out_raw_ostream_NamedDecl$C(Out, $Deref(VD));
            ElemTy.$assignMove(VD.getType());
          } else {
            /*const*/ Expr /*P*/ E = Base.get(/*const*/ Expr /*P*/.class);
            assert (E != null) : "Expecting non-null Expr";
            E.printPretty(Out, (PrinterHelper /*P*/ )null, Ctx.getPrintingPolicy());
            ElemTy.$assignMove(E.getType());
          }
        }
        
        ArrayRef<LValuePathEntry> Path = getLValuePath();
        /*const*/ CXXRecordDecl /*P*/ CastToBase = null;
        for (/*uint*/int I = 0, N = Path.size(); I != N; ++I) {
          if ((ElemTy.$arrow().getAs$RecordType() != null)) {
            // The lvalue refers to a class type, so the next path entry is a base
            // or member.
            /*const*/ Decl /*P*/ BaseOrMember = PointerBoolPair.</*const*/ Decl/*P*/>getFromOpaqueValue_voidPtr(Path.$at(I).BaseOrMember).getPointer();
            {
              /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(BaseOrMember);
              if ((RD != null)) {
                CastToBase = RD;
                ElemTy.$assignMove(Ctx.getRecordType(RD));
              } else {
                /*const*/ ValueDecl /*P*/ VD = cast_ValueDecl(BaseOrMember);
                Out.$out(/*KEEP_STR*/$DOT);
                if ((CastToBase != null)) {
                  $out_raw_ostream_NamedDecl$C(Out, $Deref(CastToBase)).$out(/*KEEP_STR*/$COLON_COLON);
                }
                $out_raw_ostream_NamedDecl$C(Out, $Deref(VD));
                ElemTy.$assignMove(VD.getType());
              }
            }
          } else {
            // The lvalue must refer to an array.
            Out.$out_char($$LSQUARE).$out_ullong(Path.$at(I).ArrayIndex).$out_char($$RSQUARE);
            ElemTy.$assignMove(Ctx.getAsArrayType(new QualType(ElemTy)).getElementType());
          }
        }
        
        // Handle formatting of one-past-the-end lvalues.
        if (isLValueOnePastTheEnd()) {
          // FIXME: If CastToBase is non-0, we should prefix the output with
          // "(CastToBase*)".
          Out.$out(/*KEEP_STR*/" + 1");
          if (IsReference) {
            Out.$out_char($$RPAREN);
          }
        }
        return;
      }
     case Array:
      {
        /*const*/ ArrayType /*P*/ AT = Ctx.getAsArrayType(new QualType(Ty));
        QualType ElemTy = AT.getElementType();
        Out.$out_char($$LCURLY);
        {
          /*uint*/int N = getArrayInitializedElts();
          if ((N != 0)) {
            getArrayInitializedElt$Const(0).printPretty(Out, Ctx, new QualType(ElemTy));
            for (/*uint*/int I = 1; I != N; ++I) {
              Out.$out(/*KEEP_STR*/$COMMA_SPACE);
              if (I == 10) {
                // Avoid printing out the entire contents of large arrays.
                Out.$out(/*KEEP_STR*/$ELLIPSIS);
                break;
              }
              getArrayInitializedElt$Const(I).printPretty(Out, Ctx, new QualType(ElemTy));
            }
          }
        }
        Out.$out_char($$RCURLY);
        return;
      }
     case Struct:
      {
        Out.$out_char($$LCURLY);
        /*const*/ RecordDecl /*P*/ RD = Ty.$arrow().getAs$RecordType().getDecl();
        boolean First = true;
        {
          /*uint*/int N = getStructNumBases();
          if ((N != 0)) {
            /*const*/ CXXRecordDecl /*P*/ CD = cast_CXXRecordDecl(RD);
            type$ptr</*const*/ CXXBaseSpecifier /*P*/ > BI = $tryClone(CD.bases_begin$Const());
            for (/*uint*/int I = 0; I != N; ++I , BI.$preInc()) {
              assert ($noteq_ptr(BI, CD.bases_end$Const()));
              if (!First) {
                Out.$out(/*KEEP_STR*/$COMMA_SPACE);
              }
              getStructBase$Const(I).printPretty(Out, Ctx, BI./*->*/$star().getType());
              First = false;
            }
          }
        }
        for (/*const*/ FieldDecl /*P*/ FI : RD.fields()) {
          if (!First) {
            Out.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          if (FI.isUnnamedBitfield()) {
            continue;
          }
          getStructField$Const(FI.getFieldIndex()).
              printPretty(Out, Ctx, FI.getType());
          First = false;
        }
        Out.$out_char($$RCURLY);
        return;
      }
     case Union:
      Out.$out_char($$LCURLY);
      {
        /*const*/ FieldDecl /*P*/ FD = getUnionField();
        if ((FD != null)) {
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/$DOT), $Deref(FD)).$out(/*KEEP_STR*/" = ");
          getUnionValue$Const().printPretty(Out, Ctx, FD.getType());
        }
      }
      Out.$out_char($$RCURLY);
      return;
     case MemberPointer:
      {
        // FIXME: This is not enough to unambiguously identify the member in a
        // multiple-inheritance scenario.
        /*const*/ ValueDecl /*P*/ VD = getMemberPointerDecl();
        if ((VD != null)) {
          $out_raw_ostream_NamedDecl$C($out_raw_ostream_NamedDecl$C(Out.$out_char($$AMP), $Deref(cast_CXXRecordDecl(VD.getDeclContext$Const()))).$out(/*KEEP_STR*/$COLON_COLON), $Deref(VD));
          return;
        }
      }
      Out.$out(/*KEEP_STR*/$0);
      return;
     case AddrLabelDiff:
      Out.$out(/*KEEP_STR*/$AMP_AMP).$out(getAddrLabelDiffLHS().getLabel().getName());
      Out.$out(/*KEEP_STR*/" - ");
      Out.$out(/*KEEP_STR*/$AMP_AMP).$out(getAddrLabelDiffRHS().getLabel().getName());
      return;
    }
    throw new llvm_unreachable("Unknown APValue kind!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 545,
   FQN="clang::APValue::getAsString", NM="_ZNK5clang7APValue11getAsStringERNS_10ASTContextENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue11getAsStringERNS_10ASTContextENS_8QualTypeE")
  //</editor-fold>
  public std.string getAsString(final ASTContext /*&*/ Ctx, QualType Ty) /*const*/ {
    raw_string_ostream Out = null;
    try {
      std.string Result/*J*/= new std.string();
      Out/*J*/= new raw_string_ostream(Result);
      printPretty(Out, Ctx, new QualType(Ty));
      Out.flush();
      return Result;
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 200,
   FQN="clang::APValue::getInt", NM="_ZN5clang7APValue6getIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue6getIntEv")
  //</editor-fold>
  public APSInt /*&*/ getInt() {
    assert (isInt()) : "Invalid accessor";
    return /*Deref*/(APSInt /*P*/ )Data.buffer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 204,
   FQN="clang::APValue::getInt", NM="_ZNK5clang7APValue6getIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue6getIntEv")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ getInt$Const() /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getInt();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getFloat">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 208,
   FQN="clang::APValue::getFloat", NM="_ZN5clang7APValue8getFloatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue8getFloatEv")
  //</editor-fold>
  public APFloat /*&*/ getFloat() {
    assert (isFloat()) : "Invalid accessor";
    return /*Deref*/(APFloat /*P*/ )Data.buffer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 212,
   FQN="clang::APValue::getFloat", NM="_ZNK5clang7APValue8getFloatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue8getFloatEv")
  //</editor-fold>
  public /*const*/ APFloat /*&*/ getFloat$Const() /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getFloat();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getComplexIntReal">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 216,
   FQN="clang::APValue::getComplexIntReal", NM="_ZN5clang7APValue17getComplexIntRealEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue17getComplexIntRealEv")
  //</editor-fold>
  public APSInt /*&*/ getComplexIntReal() {
    assert (isComplexInt()) : "Invalid accessor";
    return ((ComplexAPSInt /*P*/ )Data.buffer).Real;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getComplexIntReal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 220,
   FQN="clang::APValue::getComplexIntReal", NM="_ZNK5clang7APValue17getComplexIntRealEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue17getComplexIntRealEv")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ getComplexIntReal$Const() /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getComplexIntReal();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getComplexIntImag">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 224,
   FQN="clang::APValue::getComplexIntImag", NM="_ZN5clang7APValue17getComplexIntImagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue17getComplexIntImagEv")
  //</editor-fold>
  public APSInt /*&*/ getComplexIntImag() {
    assert (isComplexInt()) : "Invalid accessor";
    return ((ComplexAPSInt /*P*/ )Data.buffer).Imag;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getComplexIntImag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 228,
   FQN="clang::APValue::getComplexIntImag", NM="_ZNK5clang7APValue17getComplexIntImagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue17getComplexIntImagEv")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ getComplexIntImag$Const() /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getComplexIntImag();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getComplexFloatReal">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 232,
   FQN="clang::APValue::getComplexFloatReal", NM="_ZN5clang7APValue19getComplexFloatRealEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue19getComplexFloatRealEv")
  //</editor-fold>
  public APFloat /*&*/ getComplexFloatReal() {
    assert (isComplexFloat()) : "Invalid accessor";
    return ((ComplexAPFloat /*P*/ )Data.buffer).Real;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getComplexFloatReal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 236,
   FQN="clang::APValue::getComplexFloatReal", NM="_ZNK5clang7APValue19getComplexFloatRealEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue19getComplexFloatRealEv")
  //</editor-fold>
  public /*const*/ APFloat /*&*/ getComplexFloatReal$Const() /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getComplexFloatReal();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getComplexFloatImag">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 240,
   FQN="clang::APValue::getComplexFloatImag", NM="_ZN5clang7APValue19getComplexFloatImagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue19getComplexFloatImagEv")
  //</editor-fold>
  public APFloat /*&*/ getComplexFloatImag() {
    assert (isComplexFloat()) : "Invalid accessor";
    return ((ComplexAPFloat /*P*/ )Data.buffer).Imag;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getComplexFloatImag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 244,
   FQN="clang::APValue::getComplexFloatImag", NM="_ZNK5clang7APValue19getComplexFloatImagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue19getComplexFloatImagEv")
  //</editor-fold>
  public /*const*/ APFloat /*&*/ getComplexFloatImag$Const() /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getComplexFloatImag();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getLValueBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 553,
   FQN="clang::APValue::getLValueBase", NM="_ZNK5clang7APValue13getLValueBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue13getLValueBaseEv")
  //</editor-fold>
  public /*const*/ PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > getLValueBase() /*const*/ {
    assert (isLValue()) : "Invalid accessor";
    return ((/*const*/ LV /*P*/ )reinterpret_cast(/*const*/Object/*void P*/ .class, Data.buffer)).BaseAndIsOnePastTheEnd.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getLValueOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 563,
   FQN="clang::APValue::getLValueOffset", NM="_ZN5clang7APValue15getLValueOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue15getLValueOffsetEv")
  //</editor-fold>
  public CharUnits /*&*/ getLValueOffset() {
    assert (isLValue()) : "Invalid accessor";
    return ((LV /*P*/ )reinterpret_cast(Object/*void P*/ .class, Data.buffer)).Offset;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getLValueOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 250,
   FQN="clang::APValue::getLValueOffset", NM="_ZNK5clang7APValue15getLValueOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue15getLValueOffsetEv")
  //</editor-fold>
  public /*const*/ CharUnits /*&*/ getLValueOffset$Const() /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getLValueOffset();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isLValueOnePastTheEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 558,
   FQN="clang::APValue::isLValueOnePastTheEnd", NM="_ZNK5clang7APValue21isLValueOnePastTheEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue21isLValueOnePastTheEndEv")
  //</editor-fold>
  public boolean isLValueOnePastTheEnd() /*const*/ {
    assert (isLValue()) : "Invalid accessor";
    return ((/*const*/ LV /*P*/ )reinterpret_cast(/*const*/Object/*void P*/ .class, Data.buffer)).BaseAndIsOnePastTheEnd.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::hasLValuePath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 568,
   FQN="clang::APValue::hasLValuePath", NM="_ZNK5clang7APValue13hasLValuePathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue13hasLValuePathEv")
  //</editor-fold>
  public boolean hasLValuePath() /*const*/ {
    assert (isLValue()) : "Invalid accessor";
    return ((/*const*/ LV /*P*/ )Data.buffer).hasPath();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getLValuePath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 573,
   FQN="clang::APValue::getLValuePath", NM="_ZNK5clang7APValue13getLValuePathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue13getLValuePathEv")
  //</editor-fold>
  public ArrayRef<APValue.LValuePathEntry> getLValuePath() /*const*/ {
    assert (isLValue() && hasLValuePath()) : "Invalid accessor";
    final /*const*/ LV /*&*/ LVal = $Deref(((/*const*/ LV /*P*/ )Data.buffer));
    return llvm.makeArrayRef(LVal.getPath$Const(), LVal.PathLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getLValueCallIndex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 579,
   FQN="clang::APValue::getLValueCallIndex", NM="_ZNK5clang7APValue18getLValueCallIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue18getLValueCallIndexEv")
  //</editor-fold>
  public /*uint*/int getLValueCallIndex() /*const*/ {
    assert (isLValue()) : "Invalid accessor";
    return ((/*const*/ LV /*P*/ )Data.buffer).CallIndex;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getVectorElt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 258,
   FQN="clang::APValue::getVectorElt", NM="_ZN5clang7APValue12getVectorEltEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue12getVectorEltEj")
  //</editor-fold>
  public APValue /*&*/ getVectorElt(/*uint*/int I) {
    assert (isVector()) : "Invalid accessor";
    assert ($less_uint(I, getVectorLength())) : "Index out of range";
    return ((Vec /*P*/ )Data.buffer).Elts[I];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getVectorElt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 263,
   FQN="clang::APValue::getVectorElt", NM="_ZNK5clang7APValue12getVectorEltEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue12getVectorEltEj")
  //</editor-fold>
  public /*const*/ APValue /*&*/ getVectorElt$Const(/*uint*/int I) /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getVectorElt(I);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getVectorLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 266,
   FQN="clang::APValue::getVectorLength", NM="_ZNK5clang7APValue15getVectorLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue15getVectorLengthEv")
  //</editor-fold>
  public /*uint*/int getVectorLength() /*const*/ {
    assert (isVector()) : "Invalid accessor";
    return ((/*const*/ Vec /*P*/ )reinterpret_cast(/*const*/Object/*void P*/ .class, Data.buffer)).NumElts;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getArrayInitializedElt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 271,
   FQN="clang::APValue::getArrayInitializedElt", NM="_ZN5clang7APValue22getArrayInitializedEltEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue22getArrayInitializedEltEj")
  //</editor-fold>
  public APValue /*&*/ getArrayInitializedElt(/*uint*/int I) {
    assert (isArray()) : "Invalid accessor";
    assert ($less_uint(I, getArrayInitializedElts())) : "Index out of range";
    return ((Arr /*P*/ )Data.buffer).Elts[I];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getArrayInitializedElt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 276,
   FQN="clang::APValue::getArrayInitializedElt", NM="_ZNK5clang7APValue22getArrayInitializedEltEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue22getArrayInitializedEltEj")
  //</editor-fold>
  public /*const*/ APValue /*&*/ getArrayInitializedElt$Const(/*uint*/int I) /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getArrayInitializedElt(I);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::hasArrayFiller">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 279,
   FQN="clang::APValue::hasArrayFiller", NM="_ZNK5clang7APValue14hasArrayFillerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue14hasArrayFillerEv")
  //</editor-fold>
  public boolean hasArrayFiller() /*const*/ {
    return getArrayInitializedElts() != getArraySize();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getArrayFiller">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 282,
   FQN="clang::APValue::getArrayFiller", NM="_ZN5clang7APValue14getArrayFillerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue14getArrayFillerEv")
  //</editor-fold>
  public APValue /*&*/ getArrayFiller() {
    assert (isArray()) : "Invalid accessor";
    assert (hasArrayFiller()) : "No array filler";
    return ((Arr /*P*/ )Data.buffer).Elts[getArrayInitializedElts()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getArrayFiller">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 287,
   FQN="clang::APValue::getArrayFiller", NM="_ZNK5clang7APValue14getArrayFillerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue14getArrayFillerEv")
  //</editor-fold>
  public /*const*/ APValue /*&*/ getArrayFiller$Const() /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getArrayFiller();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getArrayInitializedElts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 290,
   FQN="clang::APValue::getArrayInitializedElts", NM="_ZNK5clang7APValue23getArrayInitializedEltsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue23getArrayInitializedEltsEv")
  //</editor-fold>
  public /*uint*/int getArrayInitializedElts() /*const*/ {
    assert (isArray()) : "Invalid accessor";
    return ((/*const*/ Arr /*P*/ )reinterpret_cast(/*const*/Object/*void P*/ .class, Data.buffer)).NumElts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getArraySize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 294,
   FQN="clang::APValue::getArraySize", NM="_ZNK5clang7APValue12getArraySizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue12getArraySizeEv")
  //</editor-fold>
  public /*uint*/int getArraySize() /*const*/ {
    assert (isArray()) : "Invalid accessor";
    return ((/*const*/ Arr /*P*/ )reinterpret_cast(/*const*/Object/*void P*/ .class, Data.buffer)).ArrSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getStructNumBases">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 299,
   FQN="clang::APValue::getStructNumBases", NM="_ZNK5clang7APValue17getStructNumBasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue17getStructNumBasesEv")
  //</editor-fold>
  public /*uint*/int getStructNumBases() /*const*/ {
    assert (isStruct()) : "Invalid accessor";
    return ((/*const*/ StructData /*P*/ )Data.buffer).NumBases;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getStructNumFields">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 303,
   FQN="clang::APValue::getStructNumFields", NM="_ZNK5clang7APValue18getStructNumFieldsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue18getStructNumFieldsEv")
  //</editor-fold>
  public /*uint*/int getStructNumFields() /*const*/ {
    assert (isStruct()) : "Invalid accessor";
    return ((/*const*/ StructData /*P*/ )Data.buffer).NumFields;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getStructBase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 307,
   FQN="clang::APValue::getStructBase", NM="_ZN5clang7APValue13getStructBaseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue13getStructBaseEj")
  //</editor-fold>
  public APValue /*&*/ getStructBase(/*uint*/int i) {
    assert (isStruct()) : "Invalid accessor";
    return ((StructData /*P*/ )Data.buffer).Elts[i];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getStructField">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 311,
   FQN="clang::APValue::getStructField", NM="_ZN5clang7APValue14getStructFieldEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue14getStructFieldEj")
  //</editor-fold>
  public APValue /*&*/ getStructField(/*uint*/int i) {
    assert (isStruct()) : "Invalid accessor";
    return ((StructData /*P*/ )Data.buffer).Elts[getStructNumBases() + i];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getStructBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 315,
   FQN="clang::APValue::getStructBase", NM="_ZNK5clang7APValue13getStructBaseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue13getStructBaseEj")
  //</editor-fold>
  public /*const*/ APValue /*&*/ getStructBase$Const(/*uint*/int i) /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getStructBase(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getStructField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 318,
   FQN="clang::APValue::getStructField", NM="_ZNK5clang7APValue14getStructFieldEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue14getStructFieldEj")
  //</editor-fold>
  public /*const*/ APValue /*&*/ getStructField$Const(/*uint*/int i) /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getStructField(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getUnionField">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 322,
   FQN="clang::APValue::getUnionField", NM="_ZNK5clang7APValue13getUnionFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue13getUnionFieldEv")
  //</editor-fold>
  public /*const*/ FieldDecl /*P*/ getUnionField() /*const*/ {
    assert (isUnion()) : "Invalid accessor";
    return ((/*const*/ UnionData /*P*/ )Data.buffer).Field;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getUnionValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 326,
   FQN="clang::APValue::getUnionValue", NM="_ZN5clang7APValue13getUnionValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue13getUnionValueEv")
  //</editor-fold>
  public APValue /*&*/ getUnionValue() {
    assert (isUnion()) : "Invalid accessor";
    return $Deref(((UnionData /*P*/ )Data.buffer).Value);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getUnionValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 330,
   FQN="clang::APValue::getUnionValue", NM="_ZNK5clang7APValue13getUnionValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue13getUnionValueEv")
  //</editor-fold>
  public /*const*/ APValue /*&*/ getUnionValue$Const() /*const*/ {
    return ((/*const_cast*/APValue /*P*/ )(this)).getUnionValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getMemberPointerDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 608,
   FQN="clang::APValue::getMemberPointerDecl", NM="_ZNK5clang7APValue20getMemberPointerDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue20getMemberPointerDeclEv")
  //</editor-fold>
  public /*const*/ ValueDecl /*P*/ getMemberPointerDecl() /*const*/ {
    assert (isMemberPointer()) : "Invalid accessor";
    final /*const*/ MemberPointerData /*&*/ MPD = $Deref(((/*const*/ MemberPointerData /*P*/ )Data.buffer));
    return MPD.MemberAndIsDerivedMember.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::isMemberPointerToDerivedMember">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 615,
   FQN="clang::APValue::isMemberPointerToDerivedMember", NM="_ZNK5clang7APValue30isMemberPointerToDerivedMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue30isMemberPointerToDerivedMemberEv")
  //</editor-fold>
  public boolean isMemberPointerToDerivedMember() /*const*/ {
    assert (isMemberPointer()) : "Invalid accessor";
    final /*const*/ MemberPointerData /*&*/ MPD = $Deref(((/*const*/ MemberPointerData /*P*/ )Data.buffer));
    return MPD.MemberAndIsDerivedMember.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getMemberPointerPath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 622,
   FQN="clang::APValue::getMemberPointerPath", NM="_ZNK5clang7APValue20getMemberPointerPathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue20getMemberPointerPathEv")
  //</editor-fold>
  public ArrayRef</*const*/ CXXRecordDecl /*P*/ > getMemberPointerPath() /*const*/ {
    assert (isMemberPointer()) : "Invalid accessor";
    final /*const*/ MemberPointerData /*&*/ MPD = $Deref(((/*const*/ MemberPointerData /*P*/ )Data.buffer));
    return llvm.makeArrayRef(MPD.getPath$Const(), MPD.PathLength);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getAddrLabelDiffLHS">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 338,
   FQN="clang::APValue::getAddrLabelDiffLHS", NM="_ZNK5clang7APValue19getAddrLabelDiffLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue19getAddrLabelDiffLHSEv")
  //</editor-fold>
  public /*const*/ AddrLabelExpr /*P*/ getAddrLabelDiffLHS() /*const*/ {
    assert (isAddrLabelDiff()) : "Invalid accessor";
    return ((/*const*/ AddrLabelDiffData /*P*/ )Data.buffer).LHSExpr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::getAddrLabelDiffRHS">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 342,
   FQN="clang::APValue::getAddrLabelDiffRHS", NM="_ZNK5clang7APValue19getAddrLabelDiffRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZNK5clang7APValue19getAddrLabelDiffRHSEv")
  //</editor-fold>
  public /*const*/ AddrLabelExpr /*P*/ getAddrLabelDiffRHS() /*const*/ {
    assert (isAddrLabelDiff()) : "Invalid accessor";
    return ((/*const*/ AddrLabelDiffData /*P*/ )Data.buffer).RHSExpr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::setInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 347,
   FQN="clang::APValue::setInt", NM="_ZN5clang7APValue6setIntEN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue6setIntEN4llvm6APSIntE")
  //</editor-fold>
  public void setInt(APSInt I) {
    assert (isInt()) : "Invalid accessor";
    /*Deref*/((APSInt /*P*/ )Data.buffer).$assignMove(std.move(I));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::setFloat">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 351,
   FQN="clang::APValue::setFloat", NM="_ZN5clang7APValue8setFloatEN4llvm7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue8setFloatEN4llvm7APFloatE")
  //</editor-fold>
  public void setFloat(APFloat F) {
    assert (isFloat()) : "Invalid accessor";
    /*Deref*/((APFloat /*P*/ )Data.buffer).$assignMove(std.move(F));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::setVector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 355,
   FQN="clang::APValue::setVector", NM="_ZN5clang7APValue9setVectorEPKS0_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue9setVectorEPKS0_j")
  //</editor-fold>
  public void setVector(/*const*/ type$ptr<APValue /*P*/> E, /*uint*/int N) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (isVector()) : "Invalid accessor";
      ((Vec /*P*/ )Data.buffer).Elts = new$T(new APValue [N], APValue::new);
      ((Vec /*P*/ )Data.buffer).NumElts = N;
      for (/*uint*/int i = 0; i != N; ++i)  {
        $c$.clean(((Vec /*P*/ )Data.buffer).Elts[i].$assign($c$.track(new APValue(E.$at(i)))));
      }
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::setComplexInt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 362,
   FQN="clang::APValue::setComplexInt", NM="_ZN5clang7APValue13setComplexIntEN4llvm6APSIntES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue13setComplexIntEN4llvm6APSIntES2_")
  //</editor-fold>
  public void setComplexInt(APSInt R, APSInt I) {
    assert (R.getBitWidth() == I.getBitWidth()) : "Invalid complex int (type mismatch).";
    assert (isComplexInt()) : "Invalid accessor";
    ((ComplexAPSInt /*P*/ )/*(char$ptr)*/Data.buffer).Real.$assignMove(std.move(R));
    ((ComplexAPSInt /*P*/ )/*(char$ptr)*/Data.buffer).Imag.$assignMove(std.move(I));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::setComplexFloat">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 369,
   FQN="clang::APValue::setComplexFloat", NM="_ZN5clang7APValue15setComplexFloatEN4llvm7APFloatES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue15setComplexFloatEN4llvm7APFloatES2_")
  //</editor-fold>
  public void setComplexFloat(APFloat R, APFloat I) {
    assert ($AddrOf(R.getSemantics()) == $AddrOf(I.getSemantics())) : "Invalid complex float (type mismatch).";
    assert (isComplexFloat()) : "Invalid accessor";
    ((ComplexAPFloat /*P*/ )/*(char$ptr)*/Data.buffer).Real.$assignMove(std.move(R));
    ((ComplexAPFloat /*P*/ )/*(char$ptr)*/Data.buffer).Imag.$assignMove(std.move(I));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::setLValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 584,
   FQN="clang::APValue::setLValue", NM="_ZN5clang7APValue9setLValueEN4llvm12PointerUnionIPKNS_9ValueDeclEPKNS_4ExprEEERKNS_9CharUnitsENS0_12NoLValuePathEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue9setLValueEN4llvm12PointerUnionIPKNS_9ValueDeclEPKNS_4ExprEEERKNS_9CharUnitsENS0_12NoLValuePathEj")
  //</editor-fold>
  public void setLValue(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B, final /*const*/ CharUnits /*&*/ O, NoLValuePath $Prm2, 
           /*uint*/int CallIndex) {
    assert (isLValue()) : "Invalid accessor";
    final LV /*&*/ LVal = $Deref(((LV /*P*/ )/*(char$ptr)*/Data.buffer));
    LVal.BaseAndIsOnePastTheEnd.setPointer(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(B));
    LVal.BaseAndIsOnePastTheEnd.setInt(false);
    LVal.Offset.$assign(O);
    LVal.CallIndex = CallIndex;
    LVal.resizePath((/*uint*/int)-1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::setLValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 595,
   FQN="clang::APValue::setLValue", NM="_ZN5clang7APValue9setLValueEN4llvm12PointerUnionIPKNS_9ValueDeclEPKNS_4ExprEEERKNS_9CharUnitsENS1_8ArrayRefINS0_15LValuePathEntryEEEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue9setLValueEN4llvm12PointerUnionIPKNS_9ValueDeclEPKNS_4ExprEEERKNS_9CharUnitsENS1_8ArrayRefINS0_15LValuePathEntryEEEbj")
  //</editor-fold>
  public void setLValue(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B, final /*const*/ CharUnits /*&*/ O, 
           ArrayRef<LValuePathEntry> Path, boolean IsOnePastTheEnd, 
           /*uint*/int CallIndex) {
    assert (isLValue()) : "Invalid accessor";
    final LV /*&*/ LVal = $Deref(((LV /*P*/ )/*(char$ptr)*/Data.buffer));
    LVal.BaseAndIsOnePastTheEnd.setPointer(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(B));
    LVal.BaseAndIsOnePastTheEnd.setInt(IsOnePastTheEnd);
    LVal.Offset.$assign(O);
    LVal.CallIndex = CallIndex;
    LVal.resizePath(Path.size());
    memcpy(LVal.getPath(), Path.data(), Path.size() * (true ? /*JAVA*/1 : LValuePathEntry.$sizeof_LValuePathEntry()), false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::setUnion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 381,
   FQN="clang::APValue::setUnion", NM="_ZN5clang7APValue8setUnionEPKNS_9FieldDeclERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue8setUnionEPKNS_9FieldDeclERKS0_")
  //</editor-fold>
  public void setUnion(/*const*/ FieldDecl /*P*/ Field, final /*const*/ APValue /*&*/ Value) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (isUnion()) : "Invalid accessor";
      ((UnionData /*P*/ )/*(char$ptr)*/Data.buffer).Field = Field;
      $c$.clean(/*Deref*/((UnionData /*P*/ )/*(char$ptr)*/Data.buffer).Value.$assign($c$.track(new APValue(Value))));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::setAddrLabelDiff">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 386,
   FQN="clang::APValue::setAddrLabelDiff", NM="_ZN5clang7APValue16setAddrLabelDiffEPKNS_13AddrLabelExprES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue16setAddrLabelDiffEPKNS_13AddrLabelExprES3_")
  //</editor-fold>
  public void setAddrLabelDiff(/*const*/ AddrLabelExpr /*P*/ LHSExpr, 
                  /*const*/ AddrLabelExpr /*P*/ RHSExpr) {
    ((AddrLabelDiffData /*P*/ )/*(char$ptr)*/Data.buffer).LHSExpr = LHSExpr;
    ((AddrLabelDiffData /*P*/ )/*(char$ptr)*/Data.buffer).RHSExpr = RHSExpr;
  }

  
  /// Assign by swapping from a copy of the RHS.
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 393,
   FQN="clang::APValue::operator=", NM="_ZN5clang7APValueaSES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValueaSES0_")
  //</editor-fold>
  public APValue /*&*/ $assign(APValue RHS) {
    swap(RHS);
    return /*Deref*/this;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::APValue::DestroyDataAndMakeUninit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 189,
   FQN="clang::APValue::DestroyDataAndMakeUninit", NM="_ZN5clang7APValue24DestroyDataAndMakeUninitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue24DestroyDataAndMakeUninitEv")
  //</editor-fold>
  private void DestroyDataAndMakeUninit() {
    if (Kind == ValueKind.Int) {
      ((APSInt /*P*/ )Data.buffer).$destroy();
    } else if (Kind == ValueKind.Float) {
      ((APFloat /*P*/ )Data.buffer).$destroy();
    } else if (Kind == ValueKind.Vector) {
      ((Vec /*P*/ )Data.buffer).$destroy();
    } else if (Kind == ValueKind.ComplexInt) {
      ((ComplexAPSInt /*P*/ )Data.buffer).$destroy();
    } else if (Kind == ValueKind.ComplexFloat) {
      ((ComplexAPFloat /*P*/ )Data.buffer).$destroy();
    } else if (Kind == ValueKind.LValue) {
      ((LV /*P*/ )Data.buffer).$destroy();
    } else if (Kind == ValueKind.Array) {
      ((Arr /*P*/ )Data.buffer).$destroy();
    } else if (Kind == ValueKind.Struct) {
      ((StructData /*P*/ )Data.buffer).$destroy();
    } else if (Kind == ValueKind.Union) {
      ((UnionData /*P*/ )Data.buffer).$destroy();
    } else if (Kind == ValueKind.MemberPointer) {
      ((MemberPointerData /*P*/ )Data.buffer).$destroy();
    } else if (Kind == ValueKind.AddrLabelDiff) {
      ((AddrLabelDiffData /*P*/ )Data.buffer).$destroy();
    }
    Kind = ValueKind.Uninitialized;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeUninit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 400,
   FQN="clang::APValue::MakeUninit", NM="_ZN5clang7APValue10MakeUninitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue10MakeUninitEv")
  //</editor-fold>
  private void MakeUninit() {
    if (Kind != ValueKind.Uninitialized) {
      DestroyDataAndMakeUninit();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 404,
   FQN="clang::APValue::MakeInt", NM="_ZN5clang7APValue7MakeIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue7MakeIntEv")
  //</editor-fold>
  private void MakeInt() {
    assert (isUninit()) : "Bad state change";
    Data.buffer = 
//    /*NEW_EXPR [System]*//*new ((void *)Data.buffer)*/ $new_uint_voidPtr(reinterpret_cast(Object/*void P*/ .class, Data.buffer), (type$ptr<?> New$Mem)->{
//        return
            new APSInt(1);
//     });
    Kind = ValueKind.Int;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeFloat">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 409,
   FQN="clang::APValue::MakeFloat", NM="_ZN5clang7APValue9MakeFloatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue9MakeFloatEv")
  //</editor-fold>
  private void MakeFloat() {
    assert (isUninit()) : "Bad state change";
    Data.buffer = 
//    /*NEW_EXPR [System]*//*new ((void *)(charbyte *)Data.buffer)*/ $new_uint_voidPtr(reinterpret_cast(Object/*void P*/ .class, (char$ptr/*char P*/ )Data.buffer), (type$ptr<?> New$Mem)->{
//        return 
            new APFloat(0.);
//     });
    Kind = ValueKind.Float;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeVector">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 414,
   FQN="clang::APValue::MakeVector", NM="_ZN5clang7APValue10MakeVectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue10MakeVectorEv")
  //</editor-fold>
  private void MakeVector() {
    assert (isUninit()) : "Bad state change";
    Data.buffer = 
//    /*NEW_EXPR [System]*//*new ((void *)(charbyte *)Data.buffer)*/ $new_uint_voidPtr(reinterpret_cast(Object/*void P*/ .class, (char$ptr/*char P*/ )Data.buffer), (type$ptr<?> New$Mem)->{
//        return 
            new Vec();
//     });
    Kind = ValueKind.Vector;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeComplexInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 419,
   FQN="clang::APValue::MakeComplexInt", NM="_ZN5clang7APValue14MakeComplexIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue14MakeComplexIntEv")
  //</editor-fold>
  private void MakeComplexInt() {
    assert (isUninit()) : "Bad state change";
    Data.buffer = 
//    /*NEW_EXPR [System]*//*new ((void *)(charbyte *)Data.buffer)*/ $new_uint_voidPtr(reinterpret_cast(Object/*void P*/ .class, (char$ptr/*char P*/ )Data.buffer), (type$ptr<?> New$Mem)->{
//        return 
            new ComplexAPSInt();
//     });
    Kind = ValueKind.ComplexInt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeComplexFloat">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 424,
   FQN="clang::APValue::MakeComplexFloat", NM="_ZN5clang7APValue16MakeComplexFloatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue16MakeComplexFloatEv")
  //</editor-fold>
  private void MakeComplexFloat() {
    assert (isUninit()) : "Bad state change";
    Data.buffer = 
//    /*NEW_EXPR [System]*//*new ((void *)(charbyte *)Data.buffer)*/ $new_uint_voidPtr(reinterpret_cast(Object/*void P*/ .class, (char$ptr/*char P*/ )Data.buffer), (type$ptr<?> New$Mem)->{
//        return 
            new ComplexAPFloat();
//     });
    Kind = ValueKind.ComplexFloat;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeLValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 629,
   FQN="clang::APValue::MakeLValue", NM="_ZN5clang7APValue10MakeLValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue10MakeLValueEv")
  //</editor-fold>
  private void MakeLValue() {
    assert (isUninit()) : "Bad state change";
    static_assert($lesseq_uint(LV.$sizeof_LV(), DataSize), $("LV too big"));
    Data.buffer = 
//    /*NEW_EXPR [System]*//*new ((void *)(charbyte *)Data.buffer)*/ $new_uint_voidPtr(reinterpret_cast(Object/*void P*/ .class, (char$ptr/*char P*/ )Data.buffer), (type$ptr<?> New$Mem)->{
//        return 
            new LV();
//     });
    Kind = ValueKind.LValue;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeArray">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 636,
   FQN="clang::APValue::MakeArray", NM="_ZN5clang7APValue9MakeArrayEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue9MakeArrayEjj")
  //</editor-fold>
  private void MakeArray(/*uint*/int InitElts, /*uint*/int Size) {
    assert (isUninit()) : "Bad state change";
    Data.buffer = 
//    /*NEW_EXPR [System]*//*new ((void *)(charbyte *)Data.buffer)*/ $new_uint_voidPtr(reinterpret_cast(Object/*void P*/ .class, (char$ptr/*char P*/ )Data.buffer), (type$ptr<?> New$Mem)->{
//        return 
            new Arr(InitElts, Size);
//     });
    Kind = ValueKind.Array;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeStruct">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 431,
   FQN="clang::APValue::MakeStruct", NM="_ZN5clang7APValue10MakeStructEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue10MakeStructEjj")
  //</editor-fold>
  private void MakeStruct(/*uint*/int B, /*uint*/int M) {
    assert (isUninit()) : "Bad state change";
    Data.buffer = 
//    /*NEW_EXPR [System]*//*new ((void *)(charbyte *)Data.buffer)*/ $new_uint_voidPtr(reinterpret_cast(Object/*void P*/ .class, (char$ptr/*char P*/ )Data.buffer), (type$ptr<?> New$Mem)->{
//        return 
            new StructData(B, M);
//     });
    Kind = ValueKind.Struct;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeUnion">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 436,
   FQN="clang::APValue::MakeUnion", NM="_ZN5clang7APValue9MakeUnionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue9MakeUnionEv")
  //</editor-fold>
  private void MakeUnion() {
    assert (isUninit()) : "Bad state change";
    Data.buffer = 
//    /*NEW_EXPR [System]*//*new ((void *)(charbyte *)Data.buffer)*/ $new_uint_voidPtr(reinterpret_cast(Object/*void P*/ .class, (char$ptr/*char P*/ )Data.buffer), (type$ptr<?> New$Mem)->{
//        return 
            new UnionData();
//     });
    Kind = ValueKind.Union;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeMemberPointer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp", line = 642,
   FQN="clang::APValue::MakeMemberPointer", NM="_ZN5clang7APValue17MakeMemberPointerEPKNS_9ValueDeclEbN4llvm8ArrayRefIPKNS_13CXXRecordDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue17MakeMemberPointerEPKNS_9ValueDeclEbN4llvm8ArrayRefIPKNS_13CXXRecordDeclEEE")
  //</editor-fold>
  private void MakeMemberPointer(/*const*/ ValueDecl /*P*/ Member, boolean IsDerivedMember, 
                   ArrayRef</*const*/ CXXRecordDecl /*P*/ > Path) {
    assert (isUninit()) : "Bad state change";
    Data.buffer = 
//    MemberPointerData /*P*/ MPD = /*NEW_EXPR [System]*//*new ((void *)(charbyte *)Data.buffer)*/ $new_uint_voidPtr(reinterpret_cast(Object/*void P*/ .class, (char$ptr/*char P*/ )Data.buffer), (type$ptr<?> New$Mem)->{
//        return 
            new MemberPointerData();
//     });
    MemberPointerData /*P*/ MPD = (MemberPointerData) Data.buffer;
    Kind = ValueKind.MemberPointer;
    MPD.MemberAndIsDerivedMember.setPointer(Member);
    MPD.MemberAndIsDerivedMember.setInt(IsDerivedMember);
    MPD.resizePath(Path.size());
    memcpy(MPD.getPath(), Path.data(), Path.size() * (true ? /*JAVA*/1 : $sizeof_ptr(/* CXXRecordDecl  */)), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APValue::MakeAddrLabelDiff">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/APValue.h", line = 443,
   FQN="clang::APValue::MakeAddrLabelDiff", NM="_ZN5clang7APValue17MakeAddrLabelDiffEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN5clang7APValue17MakeAddrLabelDiffEv")
  //</editor-fold>
  private void MakeAddrLabelDiff() {
    assert (isUninit()) : "Bad state change";
    Data.buffer = 
//    /*NEW_EXPR [System]*//*new ((void *)(charbyte *)Data.buffer)*/ $new_uint_voidPtr(reinterpret_cast(Object/*void P*/ .class, (char$ptr/*char P*/ )Data.buffer), (type$ptr<?> New$Mem)->{
//        return 
            new AddrLabelDiffData();
//     });
    Kind = ValueKind.AddrLabelDiff;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void swap(final NativeSwappable /*&*/ RHS) {swap((APValue)RHS);}

  @Override public APValue clone() { return new APValue(this); }
  
  public static final class DataType extends AlignedCharArrayUnion10<Object/*void P*/ , APSInt, APFloat, ComplexAPSInt, ComplexAPFloat, Vec, Arr, StructData, UnionData, AddrLabelDiffData> {
    public static int $sizeof_DataType() {
      return 1;
    }
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Data=[" + llvm.DumpJavaString(this, APValue::dump) + "]"; // NOI18N
  }
}
