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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.analysis.analyses.analyze_format_string.*;

//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 121,
 FQN="clang::analyze_format_string::ConversionSpecifier", NM="_ZN5clang21analyze_format_string19ConversionSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19ConversionSpecifierE")
//</editor-fold>
public class ConversionSpecifier {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 123,
   FQN="clang::analyze_format_string::ConversionSpecifier::Kind", NM="_ZN5clang21analyze_format_string19ConversionSpecifier4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19ConversionSpecifier4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    InvalidSpecifier(0),
    // C99 conversion specifiers.
    cArg(InvalidSpecifier.getValue() + 1),
    dArg(cArg.getValue() + 1),
    DArg(dArg.getValue() + 1), // Apple extension
    iArg(DArg.getValue() + 1),
    IntArgBeg(Kind.dArg.getValue()),
    IntArgEnd(Kind.iArg.getValue()),
    
    oArg(IntArgEnd.getValue() + 1),
    OArg(oArg.getValue() + 1), // Apple extension
    uArg(OArg.getValue() + 1),
    UArg(uArg.getValue() + 1), // Apple extension
    xArg(UArg.getValue() + 1),
    XArg(xArg.getValue() + 1),
    UIntArgBeg(Kind.oArg.getValue()),
    UIntArgEnd(Kind.XArg.getValue()),
    
    fArg(UIntArgEnd.getValue() + 1),
    FArg(fArg.getValue() + 1),
    eArg(FArg.getValue() + 1),
    EArg(eArg.getValue() + 1),
    gArg(EArg.getValue() + 1),
    GArg(gArg.getValue() + 1),
    aArg(GArg.getValue() + 1),
    AArg(aArg.getValue() + 1),
    DoubleArgBeg(Kind.fArg.getValue()),
    DoubleArgEnd(Kind.AArg.getValue()),
    
    sArg(DoubleArgEnd.getValue() + 1),
    pArg(sArg.getValue() + 1),
    nArg(pArg.getValue() + 1),
    PercentArg(nArg.getValue() + 1),
    CArg(PercentArg.getValue() + 1),
    SArg(CArg.getValue() + 1),
    
    // ** Printf-specific **
    ZArg(SArg.getValue() + 1), // MS extension
    
    // Objective-C specific specifiers.
    ObjCObjArg(ZArg.getValue() + 1), // '@'
    ObjCBeg(Kind.ObjCObjArg.getValue()),
    ObjCEnd(Kind.ObjCObjArg.getValue()),
    
    // FreeBSD kernel specific specifiers.
    FreeBSDbArg(ObjCEnd.getValue() + 1),
    FreeBSDDArg(FreeBSDbArg.getValue() + 1),
    FreeBSDrArg(FreeBSDDArg.getValue() + 1),
    FreeBSDyArg(FreeBSDrArg.getValue() + 1),
    
    // GlibC specific specifiers.
    PrintErrno(FreeBSDyArg.getValue() + 1), // 'm'
    
    PrintfConvBeg(Kind.ObjCObjArg.getValue()),
    PrintfConvEnd(Kind.PrintErrno.getValue()),
    
    // ** Scanf-specific **
    ScanListArg(PrintfConvEnd.getValue() + 1), // '['
    ScanfConvBeg(Kind.ScanListArg.getValue()),
    ScanfConvEnd(Kind.ScanListArg.getValue());

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
  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::ConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 181,
   FQN="clang::analyze_format_string::ConversionSpecifier::ConversionSpecifier", NM="_ZN5clang21analyze_format_string19ConversionSpecifierC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19ConversionSpecifierC1Eb")
  //</editor-fold>
  public ConversionSpecifier() {
    this(true);
  }
  public ConversionSpecifier(boolean isPrintf/*= true*/) {
    // : IsPrintf(isPrintf), Position(null), EndScanList(null), kind(InvalidSpecifier) 
    //START JInit
    this.IsPrintf = isPrintf;
    this.Position = null;
    this.EndScanList = null;
    this.kind = Kind.InvalidSpecifier;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::ConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 185,
   FQN="clang::analyze_format_string::ConversionSpecifier::ConversionSpecifier", NM="_ZN5clang21analyze_format_string19ConversionSpecifierC1EbPKcNS1_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19ConversionSpecifierC1EbPKcNS1_4KindE")
  //</editor-fold>
  public ConversionSpecifier(boolean isPrintf, /*const*/char$ptr/*char P*/ pos, Kind k) {
    // : IsPrintf(isPrintf), Position(pos), EndScanList(null), kind(k) 
    //START JInit
    this.IsPrintf = isPrintf;
    this.Position = $tryClone(pos);
    this.EndScanList = null;
    this.kind = k;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::getStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 188,
   FQN="clang::analyze_format_string::ConversionSpecifier::getStart", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier8getStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier8getStartEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getStart() /*const*/ {
    return Position;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::getCharacters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 192,
   FQN="clang::analyze_format_string::ConversionSpecifier::getCharacters", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier13getCharactersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier13getCharactersEv")
  //</editor-fold>
  public StringRef getCharacters() /*const*/ {
    return new StringRef(getStart(), getLength());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::consumesDataArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 196,
   FQN="clang::analyze_format_string::ConversionSpecifier::consumesDataArgument", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier20consumesDataArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier20consumesDataArgumentEv")
  //</editor-fold>
  public boolean consumesDataArgument() /*const*/ {
    switch (kind) {
     case PrintErrno:
      assert (IsPrintf);
      return false;
     case PercentArg:
      return false;
     default:
      return true;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 208,
   FQN="clang::analyze_format_string::ConversionSpecifier::getKind", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::setKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 209,
   FQN="clang::analyze_format_string::ConversionSpecifier::setKind", NM="_ZN5clang21analyze_format_string19ConversionSpecifier7setKindENS1_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19ConversionSpecifier7setKindENS1_4KindE")
  //</editor-fold>
  public void setKind(Kind k) {
    kind = k;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 210,
   FQN="clang::analyze_format_string::ConversionSpecifier::getLength", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier9getLengthEv")
  //</editor-fold>
  public /*uint*/int getLength() /*const*/ {
    return Native.$bool(EndScanList) ? EndScanList.$sub(Position) : 1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::setEndScanList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 213,
   FQN="clang::analyze_format_string::ConversionSpecifier::setEndScanList", NM="_ZN5clang21analyze_format_string19ConversionSpecifier14setEndScanListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19ConversionSpecifier14setEndScanListEPKc")
  //</editor-fold>
  public void setEndScanList(/*const*/char$ptr/*char P*/ pos) {
    EndScanList = $tryClone(pos);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::isIntArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 215,
   FQN="clang::analyze_format_string::ConversionSpecifier::isIntArg", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier8isIntArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier8isIntArgEv")
  //</editor-fold>
  public boolean isIntArg() /*const*/ {
    return (kind.getValue() >= Kind.IntArgBeg.getValue() && kind.getValue() <= Kind.IntArgEnd.getValue())
       || kind == Kind.FreeBSDrArg || kind == Kind.FreeBSDyArg;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::isUIntArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 217,
   FQN="clang::analyze_format_string::ConversionSpecifier::isUIntArg", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier9isUIntArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier9isUIntArgEv")
  //</editor-fold>
  public boolean isUIntArg() /*const*/ {
    return kind.getValue() >= Kind.UIntArgBeg.getValue() && kind.getValue() <= Kind.UIntArgEnd.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::isAnyIntArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 218,
   FQN="clang::analyze_format_string::ConversionSpecifier::isAnyIntArg", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier11isAnyIntArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier11isAnyIntArgEv")
  //</editor-fold>
  public boolean isAnyIntArg() /*const*/ {
    return kind.getValue() >= Kind.IntArgBeg.getValue() && kind.getValue() <= Kind.UIntArgEnd.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::isDoubleArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 219,
   FQN="clang::analyze_format_string::ConversionSpecifier::isDoubleArg", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier11isDoubleArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier11isDoubleArgEv")
  //</editor-fold>
  public boolean isDoubleArg() /*const*/ {
    return kind.getValue() >= Kind.DoubleArgBeg.getValue() && kind.getValue() <= Kind.DoubleArgEnd.getValue();
  }

  
  
  //===----------------------------------------------------------------------===//
  // Methods on ConversionSpecifier.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 560,
   FQN="clang::analyze_format_string::ConversionSpecifier::toString", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier8toStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier8toStringEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ __toString() /*const*/ {
    switch (kind) {
     case dArg:
      return $d;
     case DArg:
      return $D;
     case iArg:
      return $i;
     case oArg:
      return $o;
     case OArg:
      return $O;
     case uArg:
      return $u;
     case UArg:
      return $U;
     case xArg:
      return $x;
     case XArg:
      return $X;
     case fArg:
      return $f;
     case FArg:
      return $F;
     case eArg:
      return $e;
     case EArg:
      return $E;
     case gArg:
      return $g;
     case GArg:
      return $G;
     case aArg:
      return $a;
     case AArg:
      return $A;
     case cArg:
      return $c;
     case sArg:
      return $s;
     case pArg:
      return $p;
     case nArg:
      return $n;
     case PercentArg:
      return $PERCENT;
     case ScanListArg:
      return $LSQUARE;
     case InvalidSpecifier:
      return null;
     case CArg:
      
      // POSIX unicode extensions.
      return $C;
     case SArg:
      return $S;
     case ObjCObjArg:
      
      // Objective-C specific specifiers.
      return $AT;
     case FreeBSDbArg:
      
      // FreeBSD kernel specific specifiers.
      return $b;
     case FreeBSDDArg:
      return $D;
     case FreeBSDrArg:
      return $r;
     case FreeBSDyArg:
      return $y;
     case PrintErrno:
      
      // GlibC specific specifiers.
      return $m;
     case ZArg:
      
      // MS specific specifiers.
      return $Z;
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::isPrintfKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 225,
   FQN="clang::analyze_format_string::ConversionSpecifier::isPrintfKind", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier12isPrintfKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier12isPrintfKindEv")
  //</editor-fold>
  public boolean isPrintfKind() /*const*/ {
    return IsPrintf;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::getStandardSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 609,
   FQN="clang::analyze_format_string::ConversionSpecifier::getStandardSpecifier", NM="_ZNK5clang21analyze_format_string19ConversionSpecifier20getStandardSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string19ConversionSpecifier20getStandardSpecifierEv")
  //</editor-fold>
  public Optional<ConversionSpecifier> getStandardSpecifier() /*const*/ {
    ConversionSpecifier.Kind NewKind;
    switch (getKind()) {
     default:
      return new Optional<ConversionSpecifier>(None);
     case DArg:
      NewKind = Kind.dArg;
      break;
     case UArg:
      NewKind = Kind.uArg;
      break;
     case OArg:
      NewKind = Kind.oArg;
      break;
    }
    
    ConversionSpecifier FixedCS/*J*/= new ConversionSpecifier(/*Deref*/this);
    FixedCS.setKind(NewKind);
    return new Optional<ConversionSpecifier>(JD$T$C$R.INSTANCE, FixedCS);
  }

/*protected:*/
  protected boolean IsPrintf;
  protected /*const*/char$ptr/*char P*/ Position;
  protected /*const*/char$ptr/*char P*/ EndScanList;
  protected Kind kind;
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::ConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 121,
   FQN="clang::analyze_format_string::ConversionSpecifier::ConversionSpecifier", NM="_ZN5clang21analyze_format_string19ConversionSpecifierC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19ConversionSpecifierC1ERKS1_")
  //</editor-fold>
  public /*inline*/ ConversionSpecifier(final /*const*/ ConversionSpecifier /*&*/ $Prm0) {
    // : IsPrintf(.IsPrintf), Position(.Position), EndScanList(.EndScanList), kind(.kind) 
    //START JInit
    this.IsPrintf = $Prm0.IsPrintf;
    this.Position = $tryClone($Prm0.Position);
    this.EndScanList = $tryClone($Prm0.EndScanList);
    this.kind = $Prm0.kind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::ConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 121,
   FQN="clang::analyze_format_string::ConversionSpecifier::ConversionSpecifier", NM="_ZN5clang21analyze_format_string19ConversionSpecifierC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19ConversionSpecifierC1EOS1_")
  //</editor-fold>
  public /*inline*/ ConversionSpecifier(JD$Move _dparam, final ConversionSpecifier /*&&*/$Prm0) {
    // : IsPrintf(static_cast<ConversionSpecifier &&>().IsPrintf), Position(static_cast<ConversionSpecifier &&>().Position), EndScanList(static_cast<ConversionSpecifier &&>().EndScanList), kind(static_cast<ConversionSpecifier &&>().kind) 
    //START JInit
    this.IsPrintf = $Prm0.IsPrintf;
    this.Position = $tryClone($Prm0.Position);
    this.EndScanList = $tryClone($Prm0.EndScanList);
    this.kind = $Prm0.kind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ConversionSpecifier::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 121,
   FQN="clang::analyze_format_string::ConversionSpecifier::operator=", NM="_ZN5clang21analyze_format_string19ConversionSpecifieraSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19ConversionSpecifieraSERKS1_")
  //</editor-fold>
  public /*inline*/ ConversionSpecifier /*&*/ $assign(final /*const*/ ConversionSpecifier /*&*/ $Prm0) {
    this.IsPrintf = $Prm0.IsPrintf;
    this.Position = $tryClone($Prm0.Position);
    this.EndScanList = $tryClone($Prm0.EndScanList);
    this.kind = $Prm0.kind;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "IsPrintf=" + IsPrintf // NOI18N
              + ", Position=" + Position // NOI18N
              + ", EndScanList=" + EndScanList // NOI18N
              + ", kind=" + kind; // NOI18N
  }
}
