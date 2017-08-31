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

package org.clang.frontend;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.frontend.*;
import static org.clang.frontend.LangStandardsGlobals.*;


/// LangStandard - Information about the properties of a particular language
/// standard.
//<editor-fold defaultstate="collapsed" desc="clang::LangStandard">
@Converted(kind = Converted.Kind.MANUAL/*added ctr*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 39,
 FQN="clang::LangStandard", NM="_ZN5clang12LangStandardE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZN5clang12LangStandardE")
//</editor-fold>
public class/*struct*/ LangStandard {
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 40,
   FQN="clang::LangStandard::Kind", NM="_ZN5clang12LangStandard4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZN5clang12LangStandard4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    
    // C89-ish modes.
    lang_c89(0),
    lang_c90(lang_c89.getValue() + 1),
    lang_iso9899_1990(lang_c90.getValue() + 1),
    lang_c94(lang_iso9899_1990.getValue() + 1),
    lang_gnu89(lang_c94.getValue() + 1),
    lang_gnu90(lang_gnu89.getValue() + 1),
    
    // C99-ish modes
    lang_c99(lang_gnu90.getValue() + 1),
    lang_c9x(lang_c99.getValue() + 1),
    lang_iso9899_1999(lang_c9x.getValue() + 1),
    lang_iso9899_199x(lang_iso9899_1999.getValue() + 1),
    lang_gnu99(lang_iso9899_199x.getValue() + 1),
    lang_gnu9x(lang_gnu99.getValue() + 1),
    
    // C11 modes
    lang_c11(lang_gnu9x.getValue() + 1),
    lang_c1x(lang_c11.getValue() + 1),
    lang_iso9899_2011(lang_c1x.getValue() + 1),
    lang_iso9899_201x(lang_iso9899_2011.getValue() + 1),
    lang_gnu11(lang_iso9899_201x.getValue() + 1),
    lang_gnu1x(lang_gnu11.getValue() + 1),
    
    // C++ modes
    lang_cxx98(lang_gnu1x.getValue() + 1),
    lang_cxx03(lang_cxx98.getValue() + 1),
    lang_gnucxx98(lang_cxx03.getValue() + 1),
    lang_cxx0x(lang_gnucxx98.getValue() + 1),
    lang_cxx11(lang_cxx0x.getValue() + 1),
    lang_gnucxx0x(lang_cxx11.getValue() + 1),
    lang_gnucxx11(lang_gnucxx0x.getValue() + 1),
    lang_cxx1y(lang_gnucxx11.getValue() + 1),
    lang_cxx14(lang_cxx1y.getValue() + 1),
    lang_gnucxx1y(lang_cxx14.getValue() + 1),
    lang_gnucxx14(lang_gnucxx1y.getValue() + 1),
    lang_cxx1z(lang_gnucxx14.getValue() + 1),
    lang_gnucxx1z(lang_cxx1z.getValue() + 1),
    
    // OpenCL
    lang_opencl(lang_gnucxx1z.getValue() + 1),
    lang_opencl11(lang_opencl.getValue() + 1),
    lang_opencl12(lang_opencl11.getValue() + 1),
    lang_opencl20(lang_opencl12.getValue() + 1),
    
    // CUDA
    lang_cuda(lang_opencl20.getValue() + 1),
    lang_unspecified(lang_cuda.getValue() + 1);

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
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
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
  
  public /*const*/char$ptr/*char P*/ ShortName;
  public /*const*/char$ptr/*char P*/ Description;
  public /*uint*/int Flags;
/*public:*/
  /// getName - Get the name of this standard.
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 53,
   FQN="clang::LangStandard::getName", NM="_ZNK5clang12LangStandard7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard7getNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName() /*const*/ {
    return ShortName;
  }

  
  /// getDescription - Get the description of this standard.
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::getDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 56,
   FQN="clang::LangStandard::getDescription", NM="_ZNK5clang12LangStandard14getDescriptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard14getDescriptionEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getDescription() /*const*/ {
    return Description;
  }

  
  /// Language supports '//' comments.
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::hasLineComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 59,
   FQN="clang::LangStandard::hasLineComments", NM="_ZNK5clang12LangStandard15hasLineCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard15hasLineCommentsEv")
  //</editor-fold>
  public boolean hasLineComments() /*const*/ {
    return ((Flags & frontend.LangFeatures.LineComment) != 0);
  }

  
  /// isC89 - Language is a superset of C89.
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::isC89">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 62,
   FQN="clang::LangStandard::isC89", NM="_ZNK5clang12LangStandard5isC89Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard5isC89Ev")
  //</editor-fold>
  public boolean isC89() /*const*/ {
    return ((Flags & frontend.LangFeatures.C89) != 0);
  }

  
  /// isC99 - Language is a superset of C99.
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::isC99">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 65,
   FQN="clang::LangStandard::isC99", NM="_ZNK5clang12LangStandard5isC99Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard5isC99Ev")
  //</editor-fold>
  public boolean isC99() /*const*/ {
    return ((Flags & frontend.LangFeatures.C99) != 0);
  }

  
  /// isC11 - Language is a superset of C11.
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::isC11">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 68,
   FQN="clang::LangStandard::isC11", NM="_ZNK5clang12LangStandard5isC11Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard5isC11Ev")
  //</editor-fold>
  public boolean isC11() /*const*/ {
    return ((Flags & frontend.LangFeatures.C11) != 0);
  }

  
  /// isCPlusPlus - Language is a C++ variant.
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::isCPlusPlus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 71,
   FQN="clang::LangStandard::isCPlusPlus", NM="_ZNK5clang12LangStandard11isCPlusPlusEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard11isCPlusPlusEv")
  //</editor-fold>
  public boolean isCPlusPlus() /*const*/ {
    return ((Flags & frontend.LangFeatures.CPlusPlus) != 0);
  }

  
  /// isCPlusPlus11 - Language is a C++11 variant (or later).
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::isCPlusPlus11">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 74,
   FQN="clang::LangStandard::isCPlusPlus11", NM="_ZNK5clang12LangStandard13isCPlusPlus11Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard13isCPlusPlus11Ev")
  //</editor-fold>
  public boolean isCPlusPlus11() /*const*/ {
    return ((Flags & frontend.LangFeatures.CPlusPlus11) != 0);
  }

  
  /// isCPlusPlus14 - Language is a C++14 variant (or later).
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::isCPlusPlus14">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 77,
   FQN="clang::LangStandard::isCPlusPlus14", NM="_ZNK5clang12LangStandard13isCPlusPlus14Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard13isCPlusPlus14Ev")
  //</editor-fold>
  public boolean isCPlusPlus14() /*const*/ {
    return ((Flags & frontend.LangFeatures.CPlusPlus14) != 0);
  }

  
  /// isCPlusPlus1z - Language is a C++17 variant (or later).
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::isCPlusPlus1z">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 80,
   FQN="clang::LangStandard::isCPlusPlus1z", NM="_ZNK5clang12LangStandard13isCPlusPlus1zEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard13isCPlusPlus1zEv")
  //</editor-fold>
  public boolean isCPlusPlus1z() /*const*/ {
    return ((Flags & frontend.LangFeatures.CPlusPlus1z) != 0);
  }

  
  /// hasDigraphs - Language supports digraphs.
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::hasDigraphs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 83,
   FQN="clang::LangStandard::hasDigraphs", NM="_ZNK5clang12LangStandard11hasDigraphsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard11hasDigraphsEv")
  //</editor-fold>
  public boolean hasDigraphs() /*const*/ {
    return ((Flags & frontend.LangFeatures.Digraphs) != 0);
  }

  
  /// isGNUMode - Language includes GNU extensions.
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::isGNUMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 86,
   FQN="clang::LangStandard::isGNUMode", NM="_ZNK5clang12LangStandard9isGNUModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard9isGNUModeEv")
  //</editor-fold>
  public boolean isGNUMode() /*const*/ {
    return ((Flags & frontend.LangFeatures.GNUMode) != 0);
  }

  
  /// hasHexFloats - Language supports hexadecimal float constants.
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::hasHexFloats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 89,
   FQN="clang::LangStandard::hasHexFloats", NM="_ZNK5clang12LangStandard12hasHexFloatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard12hasHexFloatsEv")
  //</editor-fold>
  public boolean hasHexFloats() /*const*/ {
    return ((Flags & frontend.LangFeatures.HexFloat) != 0);
  }

  
  /// hasImplicitInt - Language allows variables to be typed as int implicitly.
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::hasImplicitInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 92,
   FQN="clang::LangStandard::hasImplicitInt", NM="_ZNK5clang12LangStandard14hasImplicitIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZNK5clang12LangStandard14hasImplicitIntEv")
  //</editor-fold>
  public boolean hasImplicitInt() /*const*/ {
    return ((Flags & frontend.LangFeatures.ImplicitInt) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::getLangStandardForKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp", line = 20,
   FQN="clang::LangStandard::getLangStandardForKind", NM="_ZN5clang12LangStandard22getLangStandardForKindENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZN5clang12LangStandard22getLangStandardForKindENS0_4KindE")
  //</editor-fold>
  public static /*const*/ LangStandard /*&*/ getLangStandardForKind(Kind K) {
    switch (K) {
     case lang_unspecified:
      llvm.report_fatal_error($("getLangStandardForKind() on unspecified kind"));
     case lang_c89:
      
      // C89-ish modes.
      return Lang_c89;
     case lang_c90:
      return Lang_c90;
     case lang_iso9899_1990:
      return Lang_iso9899_1990;
     case lang_c94:
      return Lang_c94;
     case lang_gnu89:
      return Lang_gnu89;
     case lang_gnu90:
      return Lang_gnu90;
     case lang_c99:
      
      // C99-ish modes
      return Lang_c99;
     case lang_c9x:
      return Lang_c9x;
     case lang_iso9899_1999:
      return Lang_iso9899_1999;
     case lang_iso9899_199x:
      return Lang_iso9899_199x;
     case lang_gnu99:
      return Lang_gnu99;
     case lang_gnu9x:
      return Lang_gnu9x;
     case lang_c11:
      
      // C11 modes
      return Lang_c11;
     case lang_c1x:
      return Lang_c1x;
     case lang_iso9899_2011:
      return Lang_iso9899_2011;
     case lang_iso9899_201x:
      return Lang_iso9899_201x;
     case lang_gnu11:
      return Lang_gnu11;
     case lang_gnu1x:
      return Lang_gnu1x;
     case lang_cxx98:
      
      // C++ modes
      return Lang_cxx98;
     case lang_cxx03:
      return Lang_cxx03;
     case lang_gnucxx98:
      return Lang_gnucxx98;
     case lang_cxx0x:
      return Lang_cxx0x;
     case lang_cxx11:
      return Lang_cxx11;
     case lang_gnucxx0x:
      return Lang_gnucxx0x;
     case lang_gnucxx11:
      return Lang_gnucxx11;
     case lang_cxx1y:
      return Lang_cxx1y;
     case lang_cxx14:
      return Lang_cxx14;
     case lang_gnucxx1y:
      return Lang_gnucxx1y;
     case lang_gnucxx14:
      return Lang_gnucxx14;
     case lang_cxx1z:
      return Lang_cxx1z;
     case lang_gnucxx1z:
      return Lang_gnucxx1z;
     case lang_opencl:
      
      // OpenCL
      return Lang_opencl;
     case lang_opencl11:
      return Lang_opencl11;
     case lang_opencl12:
      return Lang_opencl12;
     case lang_opencl20:
      return Lang_opencl20;
     case lang_cuda:
      
      // CUDA
      return Lang_cuda;
    }
    throw new llvm_unreachable("Invalid language kind!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangStandard::getLangStandardForName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp", line = 31,
   FQN="clang::LangStandard::getLangStandardForName", NM="_ZN5clang12LangStandard22getLangStandardForNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZN5clang12LangStandard22getLangStandardForNameEN4llvm9StringRefE")
  //</editor-fold>
  public static /*const*/ LangStandard /*P*/ getLangStandardForName(StringRef Name) {
    Kind K = new StringSwitch<Kind>(/*NO_COPY*/Name).
        // C89-ish modes.
        Case(/*KEEP_STR*/"c89", Kind.lang_c89).
        Case(/*KEEP_STR*/"c90", Kind.lang_c90).
        Case(/*KEEP_STR*/"iso9899:1990", Kind.lang_iso9899_1990).
        Case(/*KEEP_STR*/"iso9899:199409", Kind.lang_c94).
        Case(/*KEEP_STR*/"gnu89", Kind.lang_gnu89).
        Case(/*KEEP_STR*/"gnu90", Kind.lang_gnu90).
        
        // C99-ish modes
        Case(/*KEEP_STR*/"c99", Kind.lang_c99).
        Case(/*KEEP_STR*/"c9x", Kind.lang_c9x).
        Case(/*KEEP_STR*/"iso9899:1999", Kind.lang_iso9899_1999).
        Case(/*KEEP_STR*/"iso9899:199x", Kind.lang_iso9899_199x).
        Case(/*KEEP_STR*/"gnu99", Kind.lang_gnu99).
        Case(/*KEEP_STR*/"gnu9x", Kind.lang_gnu9x).
        
        // C11 modes
        Case(/*KEEP_STR*/"c11", Kind.lang_c11).
        Case(/*KEEP_STR*/"c1x", Kind.lang_c1x).
        Case(/*KEEP_STR*/"iso9899:2011", Kind.lang_iso9899_2011).
        Case(/*KEEP_STR*/"iso9899:2011", Kind.lang_iso9899_201x).
        Case(/*KEEP_STR*/"gnu11", Kind.lang_gnu11).
        Case(/*KEEP_STR*/"gnu1x", Kind.lang_gnu1x).
        
        // C++ modes
        Case(/*KEEP_STR*/"c++98", Kind.lang_cxx98).
        Case(/*KEEP_STR*/"c++03", Kind.lang_cxx03).
        Case(/*KEEP_STR*/"gnu++98", Kind.lang_gnucxx98).
        Case(/*KEEP_STR*/"c++0x", Kind.lang_cxx0x).
        Case(/*KEEP_STR*/"c++11", Kind.lang_cxx11).
        Case(/*KEEP_STR*/"gnu++0x", Kind.lang_gnucxx0x).
        Case(/*KEEP_STR*/"gnu++11", Kind.lang_gnucxx11).
        Case(/*KEEP_STR*/"c++1y", Kind.lang_cxx1y).
        Case(/*KEEP_STR*/"c++14", Kind.lang_cxx14).
        Case(/*KEEP_STR*/"gnu++1y", Kind.lang_gnucxx1y).
        Case(/*KEEP_STR*/"gnu++14", Kind.lang_gnucxx14).
        Case(/*KEEP_STR*/"c++1z", Kind.lang_cxx1z).
        Case(/*KEEP_STR*/"gnu++1z", Kind.lang_gnucxx1z).
        
        // OpenCL
        Case(/*KEEP_STR*/"cl", Kind.lang_opencl).
        Case(/*KEEP_STR*/"cl1.1", Kind.lang_opencl11).
        Case(/*KEEP_STR*/"cl1.2", Kind.lang_opencl12).
        Case(/*KEEP_STR*/"cl2.0", Kind.lang_opencl20).
        
        // CUDA
        Case(/*KEEP_STR*/"cuda", Kind.lang_cuda).Default(Kind.lang_unspecified);
    if (K == Kind.lang_unspecified) {
      return null;
    }
    
    return /*AddrOf*/getLangStandardForKind(K);
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public LangStandard(char$ptr ShortName, char$ptr Description, /*uint*/int Flags) {
    this.ShortName = $tryConstClone(ShortName);
    this.Description = $tryConstClone(Description);
    this.Flags = Flags;
  }
  
  @Override public String toString() {
    return "" + "ShortName=" + ShortName // NOI18N
              + ", Description=" + Description // NOI18N
              + ", Flags=" + Flags; // NOI18N
  }
}
