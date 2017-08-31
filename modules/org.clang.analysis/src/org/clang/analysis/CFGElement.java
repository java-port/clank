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

package org.clang.analysis;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.Native.NativePOD;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;


/// CFGElement - Represents a top-level expression in a basic block.
//<editor-fold defaultstate="collapsed" desc="clang::CFGElement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 53,
 FQN="clang::CFGElement", NM="_ZN5clang10CFGElementE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang10CFGElementE")
//</editor-fold>
public class CFGElement implements Destructors.ClassWithDestructor, NativePOD<CFGElement>, NativeMoveable<CFGElement> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGElement::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 55,
   FQN="clang::CFGElement::Kind", NM="_ZN5clang10CFGElement4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang10CFGElement4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    // main kind
    Statement(0),
    Initializer(Statement.getValue() + 1),
    NewAllocator(Initializer.getValue() + 1),
    // dtor kind
    AutomaticObjectDtor(NewAllocator.getValue() + 1),
    DeleteDtor(AutomaticObjectDtor.getValue() + 1),
    BaseDtor(DeleteDtor.getValue() + 1),
    MemberDtor(BaseDtor.getValue() + 1),
    TemporaryDtor(MemberDtor.getValue() + 1),
    DTOR_BEGIN(Kind.AutomaticObjectDtor.getValue()),
    DTOR_END(Kind.TemporaryDtor.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
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
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
/*protected:*/
  // The int bits are used to mark the kind.
  protected final PointerIntPair<Object/*void P*/ > Data1;
  protected final PointerIntPair<Object/*void P*/ > Data2;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGElement::CFGElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 75,
   FQN="clang::CFGElement::CFGElement", NM="_ZN5clang10CFGElementC1ENS0_4KindEPKvS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang10CFGElementC1ENS0_4KindEPKvS3_")
  //</editor-fold>
  protected CFGElement(Kind kind, /*const*/Object/*void P*/ Ptr1) {
    this(kind, Ptr1, (/*const*/Object/*void P*/ )null);
  }
  protected CFGElement(Kind kind, /*const*/Object/*void P*/ Ptr1, /*const*/Object/*void P*/ Ptr2/*= null*/) {
    // : Data1(const_cast<void * >(Ptr1), ((unsigned int)kind) & 0x3), Data2(const_cast<void * >(Ptr2), (((unsigned int)kind) >> 2) & 0x3) 
    //START JInit
    this.Data1 = new PointerIntPair<Object/*void P*/ >(((/*const_cast*/Object/*void P*/ )(Ptr1)), ((/*uint*/int)kind.getValue()) & 0x3);
    this.Data2 = new PointerIntPair<Object/*void P*/ >(((/*const_cast*/Object/*void P*/ )(Ptr2)), (((/*uint*/int)kind.getValue()) >>> 2) & 0x3);
    //END JInit
    assert (getKind() == kind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGElement::CFGElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 81,
   FQN="clang::CFGElement::CFGElement", NM="_ZN5clang10CFGElementC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang10CFGElementC1Ev")
  //</editor-fold>
  protected CFGElement() {
    // : Data1(), Data2() 
    //START JInit
    this.Data1 = new PointerIntPair<Object/*void P*/ >();
    this.Data2 = new PointerIntPair<Object/*void P*/ >();
    //END JInit
  }

/*public:*/
  
  /// \brief Convert to the specified CFGElement type, asserting that this
  /// CFGElement is of the desired type.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGElement::castAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 87,
   FQN="clang::CFGElement::castAs", NM="Tpl__ZNK5clang10CFGElement6castAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=Tpl__ZNK5clang10CFGElement6castAsEv")
  //</editor-fold>
  public </*typename*/ T extends CFGElement> T castAs(Class<T> clazz) /*const*/ {
    assert CFGElementToIsKind.get(clazz).$call(this);
    T t = (T)CFGElementConstuctor.get(clazz).$call();
    final CFGElement /*&*/ e = t;
    e.$assign(/*Deref*/this);
    return t;
  }

  
  /// \brief Convert to the specified CFGElement type, returning None if this
  /// CFGElement is not of the desired type.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGElement::getAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 98,
   FQN="clang::CFGElement::getAs", NM="Tpl__ZNK5clang10CFGElement5getAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=Tpl__ZNK5clang10CFGElement5getAsEv")
  //</editor-fold>
  public </*typename*/ T extends CFGElement> Optional<T> getAs(Class<T> clazz) /*const*/ {
    if (!CFGElementToIsKind.get(clazz).$call(this)) {
      return new Optional<T>(None);
    }
    T t = (T)CFGElementConstuctor.get(clazz).$call();
    final CFGElement /*&*/ e = t;
    e.$assign(/*Deref*/this);
    return new Optional<T>(JD$T$RR.INSTANCE, t);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGElement::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 107,
   FQN="clang::CFGElement::getKind", NM="_ZNK5clang10CFGElement7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang10CFGElement7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    /*uint*/int x = Data2.getInt();
    x <<= 2;
    x |= Data1.getInt();
    return Kind.valueOf(x);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGElement::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 53,
   FQN="clang::CFGElement::operator=", NM="_ZN5clang10CFGElementaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang10CFGElementaSERKS0_")
  //</editor-fold>
  public /*inline*/ CFGElement /*&*/ $assign(final /*const*/ CFGElement /*&*/ $Prm0) {
    this.Data1.$assign($Prm0.Data1);
    this.Data2.$assign($Prm0.Data2);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGElement::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 53,
   FQN="clang::CFGElement::operator=", NM="_ZN5clang10CFGElementaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang10CFGElementaSEOS0_")
  //</editor-fold>
  public /*inline*/ CFGElement /*&*/ $assignMove(final CFGElement /*&&*/$Prm0) {
    this.Data1.$assignMove($Prm0.Data1);
    this.Data2.$assignMove($Prm0.Data2);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGElement::CFGElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 53,
   FQN="clang::CFGElement::CFGElement", NM="_ZN5clang10CFGElementC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang10CFGElementC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CFGElement(final /*const*/ CFGElement /*&*/ $Prm0) {
    // : Data1(.Data1), Data2(.Data2) 
    //START JInit
    this.Data1 = new PointerIntPair<Object/*void P*/ >($Prm0.Data1);
    this.Data2 = new PointerIntPair<Object/*void P*/ >($Prm0.Data2);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGElement::CFGElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 53,
   FQN="clang::CFGElement::CFGElement", NM="_ZN5clang10CFGElementC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang10CFGElementC1EOS0_")
  //</editor-fold>
  public /*inline*/ CFGElement(JD$Move _dparam, final CFGElement /*&&*/$Prm0) {
    // : Data1(static_cast<CFGElement &&>().Data1), Data2(static_cast<CFGElement &&>().Data2) 
    //START JInit
    this.Data1 = new PointerIntPair<Object/*void P*/ >(JD$Move.INSTANCE, $Prm0.Data1);
    this.Data2 = new PointerIntPair<Object/*void P*/ >(JD$Move.INSTANCE, $Prm0.Data2);
    //END JInit
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void $destroy() { }
  
  @FunctionalInterface
  public interface Void2CFGElement {
    CFGElement $call();
  }
  
  @FunctionalInterface
  public interface CFGElement2Boolean {
    boolean $call(CFGElement p);
  }
  
  private static final java.util.Map<Class<? extends CFGElement>, Void2CFGElement> CFGElementConstuctor = new java.util.HashMap<>(64);
  private static final java.util.Map<Class<? extends CFGElement>, CFGElement2Boolean> CFGElementToIsKind = new java.util.HashMap<>(64);
  static void mapCFGElementToTypeClass(Class<? extends CFGElement> CFGElementClass, CFGElement2Boolean isKind, Void2CFGElement conctructor) {
    CFGElementConstuctor.put(CFGElementClass, conctructor);
    CFGElementToIsKind.put(CFGElementClass, isKind);
  }
  
  static { CFGElement.mapCFGElementToTypeClass(CFGBaseDtor.class, CFGBaseDtor::isKind, ()->{return new CFGBaseDtor();}); }
  static { CFGElement.mapCFGElementToTypeClass(CFGDeleteDtor.class, CFGDeleteDtor::isKind, ()->{return new CFGDeleteDtor();}); }
  static { CFGElement.mapCFGElementToTypeClass(CFGInitializer.class, CFGInitializer::isKind, ()->{return new CFGInitializer();}); }
  static { CFGElement.mapCFGElementToTypeClass(CFGStmt.class, CFGStmt::isKind, ()->{return new CFGStmt();}); }
  static { CFGElement.mapCFGElementToTypeClass(CFGTemporaryDtor.class, CFGTemporaryDtor::isKind, ()->{return new CFGTemporaryDtor();}); }
  static { CFGElement.mapCFGElementToTypeClass(CFGMemberDtor.class, CFGMemberDtor::isKind, ()->{return new CFGMemberDtor();}); }
  static { CFGElement.mapCFGElementToTypeClass(CFGAutomaticObjDtor.class, CFGAutomaticObjDtor::isKind, ()->{return new CFGAutomaticObjDtor();}); }
  static { CFGElement.mapCFGElementToTypeClass(CFGNewAllocator.class, CFGNewAllocator::isKind, ()->{return new CFGNewAllocator();}); }
  static { CFGElement.mapCFGElementToTypeClass(CFGImplicitDtor.class, CFGImplicitDtor::isKind, ()->{return new CFGImplicitDtor();}); }

  @Override
  public CFGElement clone() {
    assert this.getClass() == CFGElement.class : "why not implemented in " + this.getClass();
    return new CFGElement(this);
  }

  @Override
  public CFGElement move() {
    assert this.getClass() == CFGElement.class : "why not implemented in " + this.getClass();
    return new CFGElement(JD$Move.INSTANCE, this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Data1=" + Data1 // NOI18N
              + ", Data2=" + Data2; // NOI18N
  }
}
