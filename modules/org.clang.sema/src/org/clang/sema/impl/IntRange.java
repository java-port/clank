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

package org.clang.sema.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import org.clang.ast.*;


/// Structure recording the 'active' range of an integer-valued
/// expression.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6987,
 FQN="(anonymous namespace)::IntRange", NM="_ZN12_GLOBAL__N_18IntRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_18IntRangeE")
//</editor-fold>
public class/*struct*/ IntRange {
  /// The number of bits active in the int.
  public /*uint*/int Width;
  
  /// True if the int is known not to have negative values.
  public boolean NonNegative;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntRange::IntRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6994,
   FQN="(anonymous namespace)::IntRange::IntRange", NM="_ZN12_GLOBAL__N_18IntRangeC1Ejb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_18IntRangeC1Ejb")
  //</editor-fold>
  public IntRange(/*uint*/int Width, boolean NonNegative) {
    // : Width(Width), NonNegative(NonNegative) 
    //START JInit
    this.Width = Width;
    this.NonNegative = NonNegative;
    //END JInit
  }

  
  /// Returns the range of the bool type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntRange::forBoolType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6999,
   FQN="(anonymous namespace)::IntRange::forBoolType", NM="_ZN12_GLOBAL__N_18IntRange11forBoolTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_18IntRange11forBoolTypeEv")
  //</editor-fold>
  public static IntRange forBoolType() {
    return new IntRange(1, true);
  }

  
  /// Returns the range of an opaque value of the given integral type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntRange::forValueOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7004,
   FQN="(anonymous namespace)::IntRange::forValueOfType", NM="_ZN12_GLOBAL__N_18IntRange14forValueOfTypeERN5clang10ASTContextENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_18IntRange14forValueOfTypeERN5clang10ASTContextENS1_8QualTypeE")
  //</editor-fold>
  public static IntRange forValueOfType(final ASTContext /*&*/ C, QualType T) {
    return forValueOfCanonicalType(C, 
        T.$arrow().getCanonicalTypeInternal().getTypePtr());
  }

  
  /// Returns the range of an opaque value of a canonical integral type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntRange::forValueOfCanonicalType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7010,
   FQN="(anonymous namespace)::IntRange::forValueOfCanonicalType", NM="_ZN12_GLOBAL__N_18IntRange23forValueOfCanonicalTypeERN5clang10ASTContextEPKNS1_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_18IntRange23forValueOfCanonicalTypeERN5clang10ASTContextEPKNS1_4TypeE")
  //</editor-fold>
  public static IntRange forValueOfCanonicalType(final ASTContext /*&*/ C, /*const*/ Type /*P*/ T) {
    assert (T.isCanonicalUnqualified());
    {
      
      /*const*/ VectorType /*P*/ VT = dyn_cast(VectorType.class, T);
      if ((VT != null)) {
        T = VT.getElementType().getTypePtr();
      }
    }
    {
      /*const*/ ComplexType /*P*/ CT = dyn_cast(ComplexType.class, T);
      if ((CT != null)) {
        T = CT.getElementType().getTypePtr();
      }
    }
    {
      /*const*/ AtomicType /*P*/ AT = dyn_cast(AtomicType.class, T);
      if ((AT != null)) {
        T = AT.getValueType().getTypePtr();
      }
    }
    {
      
      // For enum types, use the known bit width of the enumerators.
      /*const*/ EnumType /*P*/ ET = dyn_cast(EnumType.class, T);
      if ((ET != null)) {
        EnumDecl /*P*/ Enum = ET.getDecl();
        if (!Enum.isCompleteDefinition()) {
          return new IntRange(C.getIntWidth(new QualType(T, 0)), false);
        }
        
        /*uint*/int NumPositive = Enum.getNumPositiveBits();
        /*uint*/int NumNegative = Enum.getNumNegativeBits();
        if (NumNegative == 0) {
          return new IntRange(NumPositive, true/*NonNegative*/);
        } else {
          return new IntRange(std.max(NumPositive + 1, NumNegative), 
              false/*NonNegative*/);
        }
      }
    }
    
    /*const*/ BuiltinType /*P*/ BT = cast(BuiltinType.class, T);
    assert (BT.isInteger());
    
    return new IntRange(C.getIntWidth(new QualType(T, 0)), BT.isUnsignedInteger());
  }

  
  /// Returns the "target" range of a canonical integral type, i.e.
  /// the range of values expressible in the type.
  ///
  /// This matches forValueOfCanonicalType except that enums have the
  /// full range of their type, not the range of their enumerators.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntRange::forTargetOfCanonicalType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7047,
   FQN="(anonymous namespace)::IntRange::forTargetOfCanonicalType", NM="_ZN12_GLOBAL__N_18IntRange24forTargetOfCanonicalTypeERN5clang10ASTContextEPKNS1_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_18IntRange24forTargetOfCanonicalTypeERN5clang10ASTContextEPKNS1_4TypeE")
  //</editor-fold>
  public static IntRange forTargetOfCanonicalType(final ASTContext /*&*/ C, /*const*/ Type /*P*/ T) {
    assert (T.isCanonicalUnqualified());
    {
      
      /*const*/ VectorType /*P*/ VT = dyn_cast(VectorType.class, T);
      if ((VT != null)) {
        T = VT.getElementType().getTypePtr();
      }
    }
    {
      /*const*/ ComplexType /*P*/ CT = dyn_cast(ComplexType.class, T);
      if ((CT != null)) {
        T = CT.getElementType().getTypePtr();
      }
    }
    {
      /*const*/ AtomicType /*P*/ AT = dyn_cast(AtomicType.class, T);
      if ((AT != null)) {
        T = AT.getValueType().getTypePtr();
      }
    }
    {
      /*const*/ EnumType /*P*/ ET = dyn_cast(EnumType.class, T);
      if ((ET != null)) {
        T = C.getCanonicalType(ET.getDecl().getIntegerType()).getTypePtr();
      }
    }
    
    /*const*/ BuiltinType /*P*/ BT = cast(BuiltinType.class, T);
    assert (BT.isInteger());
    
    return new IntRange(C.getIntWidth(new QualType(T, 0)), BT.isUnsignedInteger());
  }

  
  /// Returns the supremum of two ranges: i.e. their conservative merge.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntRange::join">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7066,
   FQN="(anonymous namespace)::IntRange::join", NM="_ZN12_GLOBAL__N_18IntRange4joinES0_S0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_18IntRange4joinES0_S0_")
  //</editor-fold>
  public static IntRange join(IntRange L, IntRange R) {
    return new IntRange(std.max(L.Width, R.Width), 
        L.NonNegative && R.NonNegative);
  }

  
  /// Returns the infinum of two ranges: i.e. their aggressive merge.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntRange::meet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7072,
   FQN="(anonymous namespace)::IntRange::meet", NM="_ZN12_GLOBAL__N_18IntRange4meetES0_S0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_18IntRange4meetES0_S0_")
  //</editor-fold>
  public static IntRange meet(IntRange L, IntRange R) {
    return new IntRange(std.min_uint(L.Width, R.Width), 
        L.NonNegative || R.NonNegative);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntRange::IntRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6987,
   FQN="(anonymous namespace)::IntRange::IntRange", NM="_ZN12_GLOBAL__N_18IntRangeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_18IntRangeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ IntRange(final /*const*/ IntRange /*&*/ $Prm0) {
    // : Width(.Width), NonNegative(.NonNegative) 
    //START JInit
    this.Width = $Prm0.Width;
    this.NonNegative = $Prm0.NonNegative;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntRange::IntRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6987,
   FQN="(anonymous namespace)::IntRange::IntRange", NM="_ZN12_GLOBAL__N_18IntRangeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_18IntRangeC1EOS0_")
  //</editor-fold>
  public /*inline*/ IntRange(JD$Move _dparam, final IntRange /*&&*/$Prm0) {
    // : Width(static_cast<IntRange &&>().Width), NonNegative(static_cast<IntRange &&>().NonNegative) 
    //START JInit
    this.Width = $Prm0.Width;
    this.NonNegative = $Prm0.NonNegative;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntRange::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6987,
   FQN="(anonymous namespace)::IntRange::operator=", NM="_ZN12_GLOBAL__N_18IntRangeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_18IntRangeaSEOS0_")
  //</editor-fold>
  public /*inline*/ IntRange /*&*/ $assignMove(final IntRange /*&&*/$Prm0) {
    this.Width = $Prm0.Width;
    this.NonNegative = $Prm0.NonNegative;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Width=" + Width // NOI18N
              + ", NonNegative=" + NonNegative; // NOI18N
  }
}
