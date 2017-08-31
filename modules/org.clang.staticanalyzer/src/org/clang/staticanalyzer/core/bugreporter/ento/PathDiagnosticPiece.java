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

package org.clang.staticanalyzer.core.bugreporter.ento;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerJavaDifferentiators.*;
import static org.clang.staticanalyzer.core.impl.PathDiagnosticStatics.*;

//===----------------------------------------------------------------------===//
// Path "pieces" for path-sensitive diagnostics.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 337,
 FQN="clang::ento::PathDiagnosticPiece", NM="_ZN5clang4ento19PathDiagnosticPieceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPieceE")
//</editor-fold>
public abstract class PathDiagnosticPiece extends /*public*/ RefCountedBaseVPTR implements Destructors.ClassWithDestructor, FoldingSetTrait.Profilable {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 339,
   FQN="clang::ento::PathDiagnosticPiece::Kind", NM="_ZN5clang4ento19PathDiagnosticPiece4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPiece4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    ControlFlow(0),
    Event(ControlFlow.getValue() + 1),
    Macro(Event.getValue() + 1),
    Call(Macro.getValue() + 1);

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
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::DisplayHint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 340,
   FQN="clang::ento::PathDiagnosticPiece::DisplayHint", NM="_ZN5clang4ento19PathDiagnosticPiece11DisplayHintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPiece11DisplayHintE")
  //</editor-fold>
  public enum DisplayHint implements Native.ComparableLower {
    Above(0),
    Below(Above.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DisplayHint valueOf(int val) {
      DisplayHint out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DisplayHint[] VALUES;
      private static final DisplayHint[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DisplayHint kind : DisplayHint.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DisplayHint[min < 0 ? (1-min) : 0];
        VALUES = new DisplayHint[max >= 0 ? (1+max) : 0];
        for (DisplayHint kind : DisplayHint.values()) {
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
    private DisplayHint(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DisplayHint)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DisplayHint)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private /*const*/std.string str;
  private /*const*/ Kind kind;
  private /*const*/ DisplayHint Hint;
  
  /// \brief In the containing bug report, this piece is the last piece from
  /// the main source file.
  private boolean LastInMainSourceFile;
  
  /// A constant string that can be used to tag the PathDiagnosticPiece,
  /// typically with the identification of the creator.  The actual pointer
  /// value is meant to be an identifier; the string itself is useful for
  /// debugging.
  private StringRef Tag;
  
  private std.vector<SourceRange> ranges;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::PathDiagnosticPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 359,
   FQN="clang::ento::PathDiagnosticPiece::PathDiagnosticPiece", NM="_ZN5clang4ento19PathDiagnosticPieceC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPieceC1Ev")
  //</editor-fold>
  private PathDiagnosticPiece() { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::PathDiagnosticPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 360,
   FQN="clang::ento::PathDiagnosticPiece::PathDiagnosticPiece", NM="_ZN5clang4ento19PathDiagnosticPieceC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPieceC1ERKS1_")
  //</editor-fold>
  private PathDiagnosticPiece(final /*const*/ PathDiagnosticPiece /*&*/ P) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 361,
   FQN="clang::ento::PathDiagnosticPiece::operator=", NM="_ZN5clang4ento19PathDiagnosticPieceaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPieceaSERKS1_")
  //</editor-fold>
  private void $assign(final /*const*/ PathDiagnosticPiece /*&*/ P) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::PathDiagnosticPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 50,
   FQN="clang::ento::PathDiagnosticPiece::PathDiagnosticPiece", NM="_ZN5clang4ento19PathDiagnosticPieceC1EN4llvm9StringRefENS1_4KindENS1_11DisplayHintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPieceC1EN4llvm9StringRefENS1_4KindENS1_11DisplayHintE")
  //</editor-fold>
  protected PathDiagnosticPiece(JD$StringRef_Kind_DisplayHint _dparam, StringRef s, 
      Kind k) {
    this(_dparam, s, 
      k, DisplayHint.Below);
  }
  protected PathDiagnosticPiece(JD$StringRef_Kind_DisplayHint _dparam, StringRef s, 
      Kind k, DisplayHint hint/*= Below*/) {
    // : RefCountedBaseVPTR(), str(StripTrailingDots(s).operator basic_string()), kind(k), Hint(hint), LastInMainSourceFile(false), Tag(), ranges() 
    //START JInit
    super();
    this.str = StripTrailingDots(new StringRef(s)).$string();
    this.kind = k;
    this.Hint = hint;
    this.LastInMainSourceFile = false;
    this.Tag = new StringRef();
    this.ranges = new std.vector<SourceRange>(new SourceRange());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::PathDiagnosticPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 55,
   FQN="clang::ento::PathDiagnosticPiece::PathDiagnosticPiece", NM="_ZN5clang4ento19PathDiagnosticPieceC1ENS1_4KindENS1_11DisplayHintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPieceC1ENS1_4KindENS1_11DisplayHintE")
  //</editor-fold>
  protected PathDiagnosticPiece(JD$Kind_DisplayHint _dparam, Kind k) {
    this(_dparam, k, DisplayHint.Below);
  }
  protected PathDiagnosticPiece(JD$Kind_DisplayHint _dparam, Kind k, DisplayHint hint/*= Below*/) {
    // : RefCountedBaseVPTR(), str(), kind(k), Hint(hint), LastInMainSourceFile(false), Tag(), ranges() 
    //START JInit
    super();
    this.str = new std.string();
    this.kind = k;
    this.Hint = hint;
    this.LastInMainSourceFile = false;
    this.Tag = new StringRef();
    this.ranges = new std.vector<SourceRange>(new SourceRange());
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::~PathDiagnosticPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 58,
   FQN="clang::ento::PathDiagnosticPiece::~PathDiagnosticPiece", NM="_ZN5clang4ento19PathDiagnosticPieceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPieceD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    ranges.$destroy();
    str.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::getString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 371,
   FQN="clang::ento::PathDiagnosticPiece::getString", NM="_ZNK5clang4ento19PathDiagnosticPiece9getStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento19PathDiagnosticPiece9getStringEv")
  //</editor-fold>
  public StringRef getString() /*const*/ {
    return new StringRef(str);
  }

  
  /// Tag this PathDiagnosticPiece with the given C-string.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::setTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 374,
   FQN="clang::ento::PathDiagnosticPiece::setTag", NM="_ZN5clang4ento19PathDiagnosticPiece6setTagEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPiece6setTagEPKc")
  //</editor-fold>
  public void setTag(/*const*/char$ptr/*char P*/ tag) {
    Tag.$assignMove(/*STRINGREF_STR*/tag);
  }

  
  /// Return the opaque tag (if any) on the PathDiagnosticPiece.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::getTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 377,
   FQN="clang::ento::PathDiagnosticPiece::getTag", NM="_ZNK5clang4ento19PathDiagnosticPiece6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento19PathDiagnosticPiece6getTagEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getTag() /*const*/ {
    return Tag.data();
  }

  
  /// Return the string representation of the tag.  This is useful
  /// for debugging.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::getTagStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 381,
   FQN="clang::ento::PathDiagnosticPiece::getTagStr", NM="_ZNK5clang4ento19PathDiagnosticPiece9getTagStrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento19PathDiagnosticPiece9getTagStrEv")
  //</editor-fold>
  public StringRef getTagStr() /*const*/ {
    return new StringRef(Tag);
  }

  
  /// getDisplayHint - Return a hint indicating where the diagnostic should
  ///  be displayed by the PathDiagnosticConsumer.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::getDisplayHint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 385,
   FQN="clang::ento::PathDiagnosticPiece::getDisplayHint", NM="_ZNK5clang4ento19PathDiagnosticPiece14getDisplayHintEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento19PathDiagnosticPiece14getDisplayHintEv")
  //</editor-fold>
  public DisplayHint getDisplayHint() /*const*/ {
    return Hint;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 387,
   FQN="clang::ento::PathDiagnosticPiece::getLocation", NM="_ZNK5clang4ento19PathDiagnosticPiece11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento19PathDiagnosticPiece11getLocationEv")
  //</editor-fold>
  public abstract /*virtual*/ PathDiagnosticLocation getLocation() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::flattenLocations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 388,
   FQN="clang::ento::PathDiagnosticPiece::flattenLocations", NM="_ZN5clang4ento19PathDiagnosticPiece16flattenLocationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPiece16flattenLocationsEv")
  //</editor-fold>
  public abstract /*virtual*/ void flattenLocations()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 390,
   FQN="clang::ento::PathDiagnosticPiece::getKind", NM="_ZNK5clang4ento19PathDiagnosticPiece7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento19PathDiagnosticPiece7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::addRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 392,
   FQN="clang::ento::PathDiagnosticPiece::addRange", NM="_ZN5clang4ento19PathDiagnosticPiece8addRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPiece8addRangeENS_11SourceRangeE")
  //</editor-fold>
  public void addRange(SourceRange R) {
    if (!R.isValid()) {
      return;
    }
    ranges.push_back_T$C$R(R);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::addRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 398,
   FQN="clang::ento::PathDiagnosticPiece::addRange", NM="_ZN5clang4ento19PathDiagnosticPiece8addRangeENS_14SourceLocationES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPiece8addRangeENS_14SourceLocationES2_")
  //</editor-fold>
  public void addRange(SourceLocation B, SourceLocation E) {
    if (!B.isValid() || !E.isValid()) {
      return;
    }
    ranges.push_back_T$RR(new SourceRange(/*NO_COPY*/B, /*NO_COPY*/E));
  }

  
  /// Return the SourceRanges associated with this PathDiagnosticPiece.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::getRanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 405,
   FQN="clang::ento::PathDiagnosticPiece::getRanges", NM="_ZNK5clang4ento19PathDiagnosticPiece9getRangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento19PathDiagnosticPiece9getRangesEv")
  //</editor-fold>
  public ArrayRef<SourceRange> getRanges() /*const*/ {
    return new ArrayRef<SourceRange>(ranges, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1062,
   FQN="clang::ento::PathDiagnosticPiece::Profile", NM="_ZNK5clang4ento19PathDiagnosticPiece7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento19PathDiagnosticPiece7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_uint((/*uint*/int)getKind().getValue());
    ID.AddString(new StringRef(str));
    // FIXME: Add profiling support for code hints.
    ID.AddInteger_uint((/*uint*/int)getDisplayHint().getValue());
    ArrayRef<SourceRange> Ranges = getRanges();
    for (type$ptr<SourceRange> I = $tryClone(Ranges.begin()), /*P*/ E = $tryClone(Ranges.end());
         $noteq_ptr(I, E); I.$preInc()) {
      ID.AddInteger_uint(I./*->*/$star().getBegin().getRawEncoding());
      ID.AddInteger_uint(I./*->*/$star().getEnd().getRawEncoding());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::setAsLastInMainSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 409,
   FQN="clang::ento::PathDiagnosticPiece::setAsLastInMainSourceFile", NM="_ZN5clang4ento19PathDiagnosticPiece25setAsLastInMainSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticPiece25setAsLastInMainSourceFileEv")
  //</editor-fold>
  public void setAsLastInMainSourceFile() {
    LastInMainSourceFile = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::isLastInMainSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 413,
   FQN="clang::ento::PathDiagnosticPiece::isLastInMainSourceFile", NM="_ZNK5clang4ento19PathDiagnosticPiece22isLastInMainSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento19PathDiagnosticPiece22isLastInMainSourceFileEv")
  //</editor-fold>
  public boolean isLastInMainSourceFile() /*const*/ {
    return LastInMainSourceFile;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticPiece::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 417,
   FQN="clang::ento::PathDiagnosticPiece::dump", NM="_ZNK5clang4ento19PathDiagnosticPiece4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento19PathDiagnosticPiece4dumpEv")
  //</editor-fold>
  public abstract /*virtual*/ void dump() /*const*//* = 0*/;

  
  @Override public String toString() {
    return "" + "str=" + str // NOI18N
              + ", kind=" + kind // NOI18N
              + ", Hint=" + Hint // NOI18N
              + ", LastInMainSourceFile=" + LastInMainSourceFile // NOI18N
              + ", Tag=" + Tag // NOI18N
              + ", ranges=" + ranges // NOI18N
              + super.toString(); // NOI18N
  }
}
