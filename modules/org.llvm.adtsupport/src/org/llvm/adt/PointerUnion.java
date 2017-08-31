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

package org.llvm.adt;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;

/**
 *
 * @author vv159170
 */

/// A discriminated union of two pointer types, with the discriminator in the
/// low bit of the pointer.
///
/// This implementation is extremely efficient in space due to leveraging the
/// low bits of the pointer, while exposing a natural and type-safe API.
///
/// Common use patterns would be something like this:
///    PointerUnion<int*, float*> P;
///    P = (int*)0;
///    printf("%d %d", P.is<int*>(), P.is<float*>());  // prints "1 0"
///    X = P.get<int*>();     // ok.
///    Y = P.get<float*>();   // runtime assertion failure.
///    Z = P.get<double*>();  // compile time failure.
///    P = (float*)0;
///    Y = P.get<float*>();   // ok.
///    X = P.get<int*>();     // runtime assertion failure.
/*template <typename PT1, typename PT2> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 83,
 FQN="llvm::PointerUnion", NM="_ZN4llvm12PointerUnionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnionE")
//</editor-fold>
public final class PointerUnion</*typename*/ PT1, /*typename*/ PT2> extends PointerUnionBase<PointerUnion<PT1, PT2>> {
///*public:*/
//  /*typedef PointerIntPair<void *, 1, bool, PointerUnionUIntTraits<PT1, PT2> > ValTy*/
////  public final class ValTy extends PointerIntPair<Object/*void P*/ , 1, boolean, PointerUnionUIntTraits<PT1, PT2> >{ };
///*private:*/
//  private PointerIntPair<Object/*void P*/ , 1, boolean, PointerUnionUIntTraits<PT1, PT2> > Val;
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::IsPT1">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 91,
//   FQN="llvm::PointerUnion::IsPT1", NM="_ZN4llvm12PointerUnion5IsPT1E",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnion5IsPT1E")
//  //</editor-fold>
//  private static class/*struct*/ IsPT1 {
//    public static /*const*/int Num = 0;
//    
//    @Override public String toString() {
//      return ""; // NOI18N
//    }
//  };
//  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::IsPT2">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 94,
//   FQN="llvm::PointerUnion::IsPT2", NM="_ZN4llvm12PointerUnion5IsPT2E",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnion5IsPT2E")
//  //</editor-fold>
//  private static class/*struct*/ IsPT2 {
//    public static /*const*/int Num = 1;
//    
//    @Override public String toString() {
//      return ""; // NOI18N
//    }
//  };
//  /*template <typename T> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::UNION_DOESNT_CONTAIN_TYPE">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 97,
//   FQN="llvm::PointerUnion::UNION_DOESNT_CONTAIN_TYPE", NM="_ZN4llvm12PointerUnion25UNION_DOESNT_CONTAIN_TYPEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnion25UNION_DOESNT_CONTAIN_TYPEE")
//  //</editor-fold>
//  public static class/*struct*/ UNION_DOESNT_CONTAIN_TYPE</*typename*/ T>  {
//    
//    @Override public String toString() {
//      return ""; // NOI18N
//    }
//  };
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::PointerUnion<PT1, PT2>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 100,
   FQN="llvm::PointerUnion::PointerUnion<PT1, PT2>", NM="_ZN4llvm12PointerUnionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnionC1Ev")
  //</editor-fold>  
  public PointerUnion(Class<PT1> first) {
    // null of the first class
    super(first, null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::PointerUnion<PT1, PT2>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 102,
   FQN="llvm::PointerUnion::PointerUnion<PT1, PT2>", NM="_ZN4llvm12PointerUnionC1ET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnionC1ET_")
  //</editor-fold>  
  public PointerUnion(JD$T firstVal, Class<PT1> first, PT1 val) {
    super(first, val);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::PointerUnion<PT1, PT2>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 105,
   FQN="llvm::PointerUnion::PointerUnion<PT1, PT2>", NM="_ZN4llvm12PointerUnionC1ET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnionC1ET0_")
  //</editor-fold>  
  public PointerUnion(JD$T1 secondVal, Class<PT2> second, PT2 val) {
    super(second, val);
  }
    
  /// If the union is set to the first pointer type get an address pointing to
  /// it.
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::getAddrOfPtr1">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 146,
   FQN="llvm::PointerUnion::getAddrOfPtr1", NM="_ZNK4llvm12PointerUnion13getAddrOfPtr1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZNK4llvm12PointerUnion13getAddrOfPtr1Ev")
  //</editor-fold>
  public /*const*/ type$ptr<PT1 /*P*/> getAddrOfPtr1$Const(Class<PT1> cls) /*const*/ {
    return super.$getAddrOfPointer(cls);
  }
  
  
  /// If the union is set to the first pointer type get an address pointing to
  /// it.
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::getAddrOfPtr1">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 152,
   FQN="llvm::PointerUnion::getAddrOfPtr1", NM="_ZN4llvm12PointerUnion13getAddrOfPtr1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnion13getAddrOfPtr1Ev")
  //</editor-fold>
  public type$ptr<PT1 /*P*/> getAddrOfPtr1(Class<PT1> cls) {
    return super.$getAddrOfPointer(cls);
  }    
  
  /// Assignment operators - Allow assigning into this union from either
  /// pointer type, setting the discriminator to remember what it came from.
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 168,
   FQN="llvm::PointerUnion::operator=", NM="_ZN4llvm12PointerUnionaSERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnionaSERKT_")
  //</editor-fold>
  public final /*const*/ PointerUnion<PT1, PT2> /*&*/ $assign_T$C$R(Class<PT1> cls, final /*const*/ PT1 /*&*/ RHS) {
    super.assign_impl(cls, RHS);
    //Val.initWithPointer(((/*const_cast*/Object/*void P*/ )(PointerLikeTypeTraits<PT1>.getAsVoidPointer(RHS))));
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 173,
   FQN="llvm::PointerUnion::operator=", NM="_ZN4llvm12PointerUnionaSERKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnionaSERKT0_")
  //</editor-fold>
  public final /*const*/ PointerUnion<PT1, PT2> /*&*/ $assign_T1$C$R(Class<PT2> cls, final /*const*/ PT2 /*&*/ RHS) {    
    super.assign_impl(cls, RHS);
//    Val.setPointerAndInt(((/*const_cast*/Object/*void P*/ )(PointerLikeTypeTraits<PT2>.getAsVoidPointer(RHS))), 
//        1);
    return /*Deref*/this;
  }  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::getFromOpaqueValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 181,
   FQN="llvm::PointerUnion::getFromOpaqueValue", NM="_ZN4llvm12PointerUnion18getFromOpaqueValueEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnion18getFromOpaqueValueEPv")
  //</editor-fold>
  public static /*inline*/ </*typename*/ PT1, /*typename*/ PT2> PointerUnion<PT1, PT2> getFromOpaqueValue(Object/*void P*/ VP) {
    PointerUnion<PT1, PT2> V = new PointerUnion(VP);
//    V.Val = PointerIntPair.<Object/*void P*/ , 1, boolean, PointerUnionUIntTraits<PT1, PT2> >getFromOpaqueValue(VP);
    return V;
  }
  
  private PointerUnion(Object /*void*/ VP) { super(VP); }  

  public PointerUnion(PointerUnion<PT1, PT2> /*&*/ RHS) {
    super(RHS);
  }

  public PointerUnion(JD$Move _dparam, PointerUnion<PT1, PT2> /*&*/ RHS) {
    super(_dparam, RHS);
  }  
  
  @Override
  public PointerUnion<PT1, PT2> clone() {
    return new PointerUnion(this);
  }
}
