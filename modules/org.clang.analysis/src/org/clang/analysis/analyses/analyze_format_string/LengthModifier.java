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

package org.clang.analysis.analyses.analyze_format_string;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clang.analysis.analyses.analyze_format_string.*;


/// Represents the length modifier in a format string in scanf/printf.
//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 65,
 FQN="clang::analyze_format_string::LengthModifier", NM="_ZN5clang21analyze_format_string14LengthModifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14LengthModifierE")
//</editor-fold>
public class LengthModifier {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 67,
   FQN="clang::analyze_format_string::LengthModifier::Kind", NM="_ZN5clang21analyze_format_string14LengthModifier4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14LengthModifier4KindE")
  //</editor-fold>
  public static final class/*enum*/ Kind {
    public static final int None = 0;
    public static final int AsChar = None + 1; // 'hh'
    public static final int AsShort = AsChar + 1; // 'h'
    public static final int AsLong = AsShort + 1; // 'l'
    public static final int AsLongLong = AsLong + 1; // 'll'
    public static final int AsQuad = AsLongLong + 1; // 'q' (BSD, deprecated, for 64-bit integer types)
    public static final int AsIntMax = AsQuad + 1; // 'j'
    public static final int AsSizeT = AsIntMax + 1; // 'z'
    public static final int AsPtrDiff = AsSizeT + 1; // 't'
    public static final int AsInt32 = AsPtrDiff + 1; // 'I32' (MSVCRT, like __int32)
    public static final int AsInt3264 = AsInt32 + 1; // 'I'   (MSVCRT, like __int3264 from MIDL)
    public static final int AsInt64 = AsInt3264 + 1; // 'I64' (MSVCRT, like __int64)
    public static final int AsLongDouble = AsInt64 + 1; // 'L'
    public static final int AsAllocate = AsLongDouble + 1; // for '%as', GNU extension to C90 scanf
    public static final int AsMAllocate = AsAllocate + 1; // for '%ms', GNU extension to scanf
    public static final int AsWide = AsMAllocate + 1; // 'w' (MSVCRT, like l but only for c, C, s, S, or Z
    public static final int AsWideChar = Kind.AsLong; // for '%ls', only makes sense for printf
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier::LengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 87,
   FQN="clang::analyze_format_string::LengthModifier::LengthModifier", NM="_ZN5clang21analyze_format_string14LengthModifierC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14LengthModifierC1Ev")
  //</editor-fold>
  public LengthModifier() {
    // : Position(null), kind(None) 
    //START JInit
    this.Position = null;
    this.kind = Kind.None;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier::LengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 89,
   FQN="clang::analyze_format_string::LengthModifier::LengthModifier", NM="_ZN5clang21analyze_format_string14LengthModifierC1EPKcNS1_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14LengthModifierC1EPKcNS1_4KindE")
  //</editor-fold>
  public LengthModifier(/*const*/char$ptr/*char P*/ pos, /*LengthModifier.Kind*/int k) {
    // : Position(pos), kind(k) 
    //START JInit
    this.Position = $tryClone(pos);
    this.kind = k;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier::getStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 92,
   FQN="clang::analyze_format_string::LengthModifier::getStart", NM="_ZNK5clang21analyze_format_string14LengthModifier8getStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14LengthModifier8getStartEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getStart() /*const*/ {
    return Position;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 96,
   FQN="clang::analyze_format_string::LengthModifier::getLength", NM="_ZNK5clang21analyze_format_string14LengthModifier9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14LengthModifier9getLengthEv")
  //</editor-fold>
  public /*uint*/int getLength() /*const*/ {
    switch (kind) {
     default:
      return 1;
     case Kind.AsLongLong:
     case Kind.AsChar:
      return 2;
     case Kind.AsInt32:
     case Kind.AsInt64:
      return 3;
     case Kind.None:
      return 0;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 111,
   FQN="clang::analyze_format_string::LengthModifier::getKind", NM="_ZNK5clang21analyze_format_string14LengthModifier7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14LengthModifier7getKindEv")
  //</editor-fold>
  public /*LengthModifier.Kind*/int getKind() /*const*/ {
    return kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier::setKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 112,
   FQN="clang::analyze_format_string::LengthModifier::setKind", NM="_ZN5clang21analyze_format_string14LengthModifier7setKindENS1_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14LengthModifier7setKindENS1_4KindE")
  //</editor-fold>
  public void setKind(/*LengthModifier.Kind*/int k) {
    kind = k;
  }

  
  
  //===----------------------------------------------------------------------===//
  // Methods on LengthModifier.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 517,
   FQN="clang::analyze_format_string::LengthModifier::toString", NM="_ZNK5clang21analyze_format_string14LengthModifier8toStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14LengthModifier8toStringEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ __toString() /*const*/ {
    switch (kind) {
     case Kind.AsChar:
      return $hh;
     case Kind.AsShort:
      return $h;
     case Kind.AsLong: // or AsWideChar
      return $l;
     case Kind.AsLongLong:
      return $ll;
     case Kind.AsQuad:
      return $q;
     case Kind.AsIntMax:
      return $j;
     case Kind.AsSizeT:
      return $z;
     case Kind.AsPtrDiff:
      return $t;
     case Kind.AsInt32:
      return $("I32");
     case Kind.AsInt3264:
      return $I;
     case Kind.AsInt64:
      return $("I64");
     case Kind.AsLongDouble:
      return $L;
     case Kind.AsAllocate:
      return $a;
     case Kind.AsMAllocate:
      return $m;
     case Kind.AsWide:
      return $w;
     case Kind.None:
      return $EMPTY;
    }
    return null;
  }

/*private:*/
  private /*const*/char$ptr/*char P*/ Position;
  private /*LengthModifier.Kind*/int kind;
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier::LengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 65,
   FQN="clang::analyze_format_string::LengthModifier::LengthModifier", NM="_ZN5clang21analyze_format_string14LengthModifierC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14LengthModifierC1ERKS1_")
  //</editor-fold>
  public /*inline*/ LengthModifier(final /*const*/ LengthModifier /*&*/ $Prm0) {
    // : Position(.Position), kind(.kind) 
    //START JInit
    this.Position = $tryClone($Prm0.Position);
    this.kind = $Prm0.kind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier::LengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 65,
   FQN="clang::analyze_format_string::LengthModifier::LengthModifier", NM="_ZN5clang21analyze_format_string14LengthModifierC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14LengthModifierC1EOS1_")
  //</editor-fold>
  public /*inline*/ LengthModifier(JD$Move _dparam, final LengthModifier /*&&*/$Prm0) {
    // : Position(static_cast<LengthModifier &&>().Position), kind(static_cast<LengthModifier &&>().kind) 
    //START JInit
    this.Position = $tryClone($Prm0.Position);
    this.kind = $Prm0.kind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::LengthModifier::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 65,
   FQN="clang::analyze_format_string::LengthModifier::operator=", NM="_ZN5clang21analyze_format_string14LengthModifieraSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14LengthModifieraSERKS1_")
  //</editor-fold>
  public /*inline*/ LengthModifier /*&*/ $assign(final /*const*/ LengthModifier /*&*/ $Prm0) {
    this.Position = $tryClone($Prm0.Position);
    this.kind = $Prm0.kind;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Position=" + Position // NOI18N
              + ", kind=" + kind; // NOI18N
  }
}
