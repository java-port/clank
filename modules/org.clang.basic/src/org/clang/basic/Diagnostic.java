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

package org.clang.basic;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.impl.DiagnosticStatics.*;
import org.clang.basic.java.diagJava;
import static org.clank.support.Native.$tryClone;
import static org.clank.support.Unsigned.*;
import org.llvm.support.sys.locale;


/// A little helper class (which is basically a smart pointer that forwards
/// info from DiagnosticsEngine) that allows clients to enquire about the
/// currently in-flight diagnostic.
//<editor-fold defaultstate="collapsed" desc="clang::Diagnostic">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1144,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1137,
 FQN="clang::Diagnostic", NM="_ZN5clang10DiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang10DiagnosticE")
//</editor-fold>
public class Diagnostic {
  private /*const*/DiagnosticsEngine /*P*/ DiagObj;
  private StringRef StoredDiagMessage;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::Diagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1148,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1141,
   FQN="clang::Diagnostic::Diagnostic", NM="_ZN5clang10DiagnosticC1EPKNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang10DiagnosticC1EPKNS_17DiagnosticsEngineE")
  //</editor-fold>
  public /*explicit*/ Diagnostic(/*const*/DiagnosticsEngine /*P*/ DO) {
    /* : DiagObj(DO), StoredDiagMessage()*/ 
    //START JInit
    this.DiagObj = DO;
    this.StoredDiagMessage = new StringRef();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::Diagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1149,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1142,
   FQN="clang::Diagnostic::Diagnostic", NM="_ZN5clang10DiagnosticC1EPKNS_17DiagnosticsEngineEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang10DiagnosticC1EPKNS_17DiagnosticsEngineEN4llvm9StringRefE")
  //</editor-fold>
  public Diagnostic(/*const*/DiagnosticsEngine /*P*/ DO, StringRef storedDiagMessage) {
    /* : DiagObj(DO), StoredDiagMessage(storedDiagMessage)*/ 
    //START JInit
    this.DiagObj = DO;
    this.StoredDiagMessage = new StringRef(storedDiagMessage);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getDiags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1152,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1145,
   FQN="clang::Diagnostic::getDiags", NM="_ZNK5clang10Diagnostic8getDiagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic8getDiagsEv")
  //</editor-fold>
  public /*const*/DiagnosticsEngine /*P*/ getDiags() /*const*/ {
    return DiagObj;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1153,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1146,
   FQN="clang::Diagnostic::getID", NM="_ZNK5clang10Diagnostic5getIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic5getIDEv")
  //</editor-fold>
  public /*uint*/int getID() /*const*/ {
    return (int)DiagObj.CurDiagID;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1154,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1147,
   FQN="clang::Diagnostic::getLocation", NM="_ZNK5clang10Diagnostic11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic11getLocationEv")
  //</editor-fold>
  public /*const*/SourceLocation /*&*/ getLocation() /*const*/ {
    return DiagObj.CurDiagLoc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::hasSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1155,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1148,
   FQN="clang::Diagnostic::hasSourceManager", NM="_ZNK5clang10Diagnostic16hasSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic16hasSourceManagerEv")
  //</editor-fold>
  public boolean hasSourceManager() /*const*/ {
    return DiagObj.hasSourceManager();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1156,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1149,
   FQN="clang::Diagnostic::getSourceManager", NM="_ZNK5clang10Diagnostic16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() /*const*/ {
    return DiagObj.getSourceManager();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1158,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1151,
   FQN="clang::Diagnostic::getNumArgs", NM="_ZNK5clang10Diagnostic10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return DiagObj.NumDiagArgs;
  }

  
  /// \brief Return the kind of the specified index.
  ///
  /// Based on the kind of argument, the accessors below can be used to get
  /// the value.
  ///
  /// \pre Idx < getNumArgs()
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getArgKind">
  @Converted(kind = Converted.Kind.MANUAL/*better assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1166,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1159,
   FQN="clang::Diagnostic::getArgKind", NM="_ZNK5clang10Diagnostic10getArgKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic10getArgKindEj")
  //</editor-fold>
  public DiagnosticsEngine.ArgumentKind getArgKind(/*uint*/int Idx) /*const*/ {
    assert (Idx < getNumArgs()) : diagJava.$name(DiagObj.CurDiagID) + " Argument index " + Idx + " out of range!" + getNumArgs();
    return DiagObj.DiagArgumentsKind[Idx];
  }

  
  /// \brief Return the provided argument string specified by \p Idx.
  /// \pre getArgKind(Idx) == DiagnosticsEngine::ak_std_string
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getArgStdStr">
  @Converted(kind = Converted.Kind.MANUAL/*better assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1173,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1166,
   FQN="clang::Diagnostic::getArgStdStr", NM="_ZNK5clang10Diagnostic12getArgStdStrEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic12getArgStdStrEj")
  //</editor-fold>
  public /*const*/std.string /*&*/ getArgStdStr(/*uint*/int Idx) /*const*/ {
    assert (getArgKind(Idx) == DiagnosticsEngine.ArgumentKind.ak_std_string) : diagJava.$name(DiagObj.CurDiagID) + " invalid argument accessor!";
    return DiagObj.DiagArgumentsStr[Idx];
  }

  
  /// \brief Return the specified C string argument.
  /// \pre getArgKind(Idx) == DiagnosticsEngine::ak_c_string
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getArgCStr">
  @Converted(kind = Converted.Kind.MANUAL/*better assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1181,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1174,
   FQN="clang::Diagnostic::getArgCStr", NM="_ZNK5clang10Diagnostic10getArgCStrEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic10getArgCStrEj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getArgCStr(/*uint*/int Idx) /*const*/ {
    assert (getArgKind(Idx) == DiagnosticsEngine.ArgumentKind.ak_c_string) : diagJava.$name(DiagObj.CurDiagID) + " invalid argument accessor!";
//    return reinterpret_ptr_cast(/*const*/char$ptr/*char P*/ .class, DiagObj.DiagArgumentsVal[Idx]);
    return (/*const*/char$ptr/*char P*/)DiagObj.DiagArgumentsVal[Idx];
  }

  
  /// \brief Return the specified signed integer argument.
  /// \pre getArgKind(Idx) == DiagnosticsEngine::ak_sint
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getArgSInt">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1189,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1182,
   FQN="clang::Diagnostic::getArgSInt", NM="_ZNK5clang10Diagnostic10getArgSIntEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic10getArgSIntEj")
  //</editor-fold>
  public int getArgSInt(/*uint*/int Idx) /*const*/ {
    assert (getArgKind(Idx) == DiagnosticsEngine.ArgumentKind.ak_sint) : diagJava.$name(DiagObj.CurDiagID) + " invalid argument accessor!";
    // JAVA: we keep Longs in DiagArgumentsVal
    return ((Number)DiagObj.DiagArgumentsVal[Idx]).intValue();
  }

  
  /// \brief Return the specified unsigned integer argument.
  /// \pre getArgKind(Idx) == DiagnosticsEngine::ak_uint
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getArgUInt">
  @Converted(kind = Converted.Kind.MANUAL/*better assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1197,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1190,
   FQN="clang::Diagnostic::getArgUInt", NM="_ZNK5clang10Diagnostic10getArgUIntEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic10getArgUIntEj")
  //</editor-fold>
  public /*uint*/int getArgUInt(/*uint*/int Idx) /*const*/ {
    assert (getArgKind(Idx) == DiagnosticsEngine.ArgumentKind.ak_uint) : diagJava.$name(DiagObj.CurDiagID) + " invalid argument accessor!";
    return ((Number)DiagObj.DiagArgumentsVal[Idx]).intValue();
  }

  
  /// \brief Return the specified IdentifierInfo argument.
  /// \pre getArgKind(Idx) == DiagnosticsEngine::ak_identifierinfo
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getArgIdentifier">
  @Converted(kind = Converted.Kind.MANUAL/*better assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1205,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1198,
   FQN="clang::Diagnostic::getArgIdentifier", NM="_ZNK5clang10Diagnostic16getArgIdentifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic16getArgIdentifierEj")
  //</editor-fold>
  public /*const*/IdentifierInfo /*P*/ getArgIdentifier(/*uint*/int Idx) /*const*/ {
    assert (getArgKind(Idx) == DiagnosticsEngine.ArgumentKind.ak_identifierinfo) : diagJava.$name(DiagObj.CurDiagID) + " invalid argument accessor!";
//    return reinterpret_cast(IdentifierInfo /*P*/ .class, DiagObj.DiagArgumentsVal[Idx]);
    return (IdentifierInfo /*P*/)DiagObj.DiagArgumentsVal[Idx];
  }

  
  /// \brief Return the specified non-string argument in an opaque form.
  /// \pre getArgKind(Idx) != DiagnosticsEngine::ak_std_string
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getRawArg">
  @Converted(kind = Converted.Kind.MANUAL/*better assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1213,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1206,
   FQN="clang::Diagnostic::getRawArg", NM="_ZNK5clang10Diagnostic9getRawArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic9getRawArgEj")
  //</editor-fold>
  public Object/*intptr_t*/ getRawArg(/*uint*/int Idx) /*const*/ {
    assert (getArgKind(Idx) != DiagnosticsEngine.ArgumentKind.ak_std_string) : diagJava.$name(DiagObj.CurDiagID) + " invalid argument accessor!";
    return DiagObj.DiagArgumentsVal[Idx];
  }

  
  /// \brief Return the number of source ranges associated with this diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getNumRanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1220,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1213,
   FQN="clang::Diagnostic::getNumRanges", NM="_ZNK5clang10Diagnostic12getNumRangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic12getNumRangesEv")
  //</editor-fold>
  public /*uint*/int getNumRanges() /*const*/ {
    return DiagObj.DiagRanges.size();
  }


  /// \pre Idx < getNumRanges()
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getRange">
  @Converted(kind = Converted.Kind.MANUAL/*better assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1225,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1218,
   FQN="clang::Diagnostic::getRange", NM="_ZNK5clang10Diagnostic8getRangeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic8getRangeEj")
  //</editor-fold>
  public /*const*/ CharSourceRange /*&*/ getRange(/*uint*/int Idx) /*const*/ {
    assert (Idx < getNumRanges()) : diagJava.$name(DiagObj.CurDiagID) + " Invalid diagnostic range index!";
    return DiagObj.DiagRanges.$at(Idx);
  }

  
  /// \brief Return an array reference for this diagnostic's ranges.
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getRanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1231,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1224,
   FQN="clang::Diagnostic::getRanges", NM="_ZNK5clang10Diagnostic9getRangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic9getRangesEv")
  //</editor-fold>
  public ArrayRef<CharSourceRange> getRanges() /*const*/ {
    return new ArrayRef<CharSourceRange>(DiagObj.DiagRanges);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getNumFixItHints">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1235,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1228,
   FQN="clang::Diagnostic::getNumFixItHints", NM="_ZNK5clang10Diagnostic16getNumFixItHintsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic16getNumFixItHintsEv")
  //</editor-fold>
  public /*uint*/int getNumFixItHints() /*const*/ {
    return DiagObj.DiagFixItHints.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getFixItHint">
  @Converted(kind = Converted.Kind.MANUAL/*better assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1239,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1232,
   FQN="clang::Diagnostic::getFixItHint", NM="_ZNK5clang10Diagnostic12getFixItHintEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic12getFixItHintEj")
  //</editor-fold>
  public /*const*/ FixItHint /*&*/ getFixItHint(/*uint*/int Idx) /*const*/ {
    assert (Idx < getNumFixItHints()) : diagJava.$name(DiagObj.CurDiagID) + " Invalid index!";
    return DiagObj.DiagFixItHints.$at(Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::getFixItHints">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1244,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1237,
   FQN="clang::Diagnostic::getFixItHints", NM="_ZNK5clang10Diagnostic13getFixItHintsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic13getFixItHintsEv")
  //</editor-fold>
  public ArrayRef<FixItHint> getFixItHints() /*const*/ {
    return new ArrayRef<FixItHint>(DiagObj.DiagFixItHints);
  }

  
  /// \brief Format this diagnostic into a string, substituting the
  /// formal arguments into the %0 slots.
  ///
  /// The result is appended onto the \p OutStr array.
  
  /// FormatDiagnostic - Format this diagnostic into a string, substituting the
  /// formal arguments into the %0 slots.  The result is appended onto the Str
  /// array.
  //<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::FormatDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 630,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 629,
   FQN="clang::Diagnostic::FormatDiagnostic", NM="_ZNK5clang10Diagnostic16FormatDiagnosticERN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic16FormatDiagnosticERN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  public void FormatDiagnostic(SmallString/*&*/ OutStr) /*const*/ {
    if (!StoredDiagMessage.empty()) {
      OutStr.append(StoredDiagMessage);
      return;
    }
    
    StringRef Diag = getDiags().getDiagnosticIDs().$arrow().getDescription(getID());
    
    FormatDiagnostic($tryClone(Diag.begin()), Diag.end(), OutStr);
  }

/// \brief Format the given format-string into the output buffer using the
/// arguments stored in this diagnostic.
//<editor-fold defaultstate="collapsed" desc="clang::Diagnostic::FormatDiagnostic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clone and assert messages*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 643,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 642,
 FQN="clang::Diagnostic::FormatDiagnostic", NM="_ZNK5clang10Diagnostic16FormatDiagnosticEPKcS2_RN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang10Diagnostic16FormatDiagnosticEPKcS2_RN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public void FormatDiagnostic(/*const*/char$ptr/*char P*/ DiagStr, /*const*/char$ptr/*char P*/ DiagEnd, 
                SmallString/*&*/ OutStr) /*const*/ {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    
    // When the diagnostic string is only "%0", the entire string is being given
    // by an outside source.  Remove unprintable characters from this string
    // and skip all the other string processing.
    if (DiagEnd.$sub(DiagStr) == 2
       && new StringRef(DiagStr, DiagEnd.$sub(DiagStr)).equals("%0")
       && getArgKind(0) == DiagnosticsEngine.ArgumentKind.ak_std_string) {
      /*const*/std.string/*&*/ S = getArgStdStr(0);
      for (char$ptr begin = S.begin(), end = S.end(); begin.$noteq(end); begin.$preInc()) {
         /*char*/byte c = begin.$star();
        if (locale.isPrint(c) || c == $$TAB) {
          OutStr.push_back(c);
        }
      }
      return;
    }
    
    /*JAVA*/DiagStr = $tryClone(DiagStr);
    
    /// FormattedArgs - Keep track of all of the arguments formatted by
    /// ConvertArgToString and pass them into subsequent calls to
    /// ConvertArgToString, allowing the implementation to avoid redundancies in
    /// obvious cases.
    SmallVector<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/>> FormattedArgs/*J*/= new SmallVector<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/>>(8, new std.pairTypePtr<DiagnosticsEngine.ArgumentKind, Object/*,intptr_t*/>(DiagnosticsEngine.ArgumentKind.ak_std_string, null));
    
    /// QualTypeVals - Pass a vector of arrays so that QualType names can be
    /// compared to see if more information is needed to be printed.
    SmallVector<Object/*intptr_t*/> QualTypeVals/*J*/= new SmallVector<Object/*intptr_t*/>(2, null);
    SmallString Tree/*J*/= new SmallString(64);
    
    for (/*uint*/int i = 0, e = getNumArgs(); $less_uint(i, e); ++i)  {
      if (getArgKind(i) == DiagnosticsEngine.ArgumentKind.ak_qualtype) {
        QualTypeVals.push_back(getRawArg(i));
      }
    }
    while (DiagStr.$noteq(DiagEnd)) {
      if (DiagStr.$at(0) != $$PERCENT) {
        // Append non-%0 substrings to Str if we have one.
        /*const*/char$ptr/*char P*/ StrEnd = $tryClone(std.find(DiagStr, DiagEnd, $$PERCENT));
        OutStr.append(DiagStr, StrEnd.$index() - DiagStr.$index());
        DiagStr = $tryClone(StrEnd);
        continue;
      } else if (isPunctuation(DiagStr.$at(1))) {
        OutStr.push_back(DiagStr.$at(1)); // %% -> %.
        DiagStr.$inc(2);
        continue;
      }
      
      // Skip the %.
      DiagStr.$preInc();
      
      // This must be a placeholder for a diagnostic argument.  The format for a
      // placeholder is one of "%0", "%modifier0", or "%modifier{arguments}0".
      // The digit is a number from 0-9 indicating which argument this comes from.
      // The modifier is a string of digits from the set [-a-z]+, arguments is a
      // brace enclosed string.
      /*const*/char$ptr/*char P*/ Modifier = null, /*P*/ Argument = null;
      /*uint*/int ModifierLen = 0, ArgumentLen = 0;
      
      // Check to see if we have a modifier.  If so eat it.
      if (!isDigit(DiagStr.$at(0))) {
        Modifier = $tryClone(DiagStr);
        while (DiagStr.$at(0) == $$MINUS
           || (DiagStr.$at(0) >= $$a && DiagStr.$at(0) <= $$z)) {
          DiagStr.$preInc();
        }
        ModifierLen = DiagStr.$sub(Modifier);
        
        // If we have an argument, get it next.
        if (DiagStr.$at(0) == $$LCURLY) {
          DiagStr.$preInc(); // Skip {.
          Argument = $tryClone(DiagStr);
          
          DiagStr = $tryClone(ScanFormat(DiagStr, DiagEnd, $$RCURLY));
          assert (DiagStr.$noteq(DiagEnd)) : diagJava.$name(DiagObj.CurDiagID) + " Mismatched {}'s in diagnostic string!";
          ArgumentLen = DiagStr.$sub(Argument);
          DiagStr.$preInc(); // Skip }.
        }
      }
      assert (isDigit(DiagStr.$star())) : diagJava.$name(DiagObj.CurDiagID) + " Invalid format for argument in diagnostic";
      /*uint*/int ArgNo = DiagStr.$postInc().$star() - $$0;
      
      // Only used for type diffing.
      /*uint*/int ArgNo2 = ArgNo;
      
      DiagnosticsEngine.ArgumentKind Kind = getArgKind(ArgNo);
      if (ModifierIs(Modifier, ModifierLen, "diff")) {
        assert (DiagStr.$star() == $$COMMA && isDigit((DiagStr.$add(1)).$star())) : diagJava.$name(DiagObj.CurDiagID) + " Invalid format for diff modifier";
        DiagStr.$preInc(); // Comma.
        ArgNo2 = DiagStr.$postInc().$star() - $$0;
        DiagnosticsEngine.ArgumentKind Kind2 = getArgKind(ArgNo2);
        if (Kind == DiagnosticsEngine.ArgumentKind.ak_qualtype
           && Kind2 == DiagnosticsEngine.ArgumentKind.ak_qualtype) {
          Kind = DiagnosticsEngine.ArgumentKind.ak_qualtype_pair;
        } else {
          // %diff only supports QualTypes.  For other kinds of arguments,
          // use the default printing.  For example, if the modifier is:
          //   "%diff{compare $ to $|other text}1,2"
          // treat it as:
          //   "compare %1 to %2"
          /*const*/char$ptr/*char P*/ Pipe = $tryClone(ScanFormat(Argument, Argument.$add(ArgumentLen), $$PIPE));
          /*const*/char$ptr/*char P*/ FirstDollar = $tryClone(ScanFormat(Argument, Pipe, $$DOLLAR));
          /*const*/char$ptr/*char P*/ SecondDollar = $tryClone(ScanFormat(FirstDollar.$add(1), Pipe, $$DOLLAR));
          /*const*//*char*/char$ptr ArgStr1 = create_char$ptr(new$char(2, $$PERCENT, ((/*static_cast*//*char*/byte)($$0 + ArgNo))));
          /*const*//*char*/char$ptr ArgStr2= create_char$ptr(new$char(2, $$PERCENT, ((/*static_cast*//*char*/byte)($$0 + ArgNo2))));
          FormatDiagnostic(Argument, FirstDollar, OutStr);
          FormatDiagnostic(ArgStr1, ArgStr1.$add(2), OutStr);
          FormatDiagnostic(FirstDollar.$add(1), SecondDollar, OutStr);
          FormatDiagnostic(ArgStr2, ArgStr2.$add(2), OutStr);
          FormatDiagnostic(SecondDollar.$add(1), Pipe, OutStr);
          continue;
        }
      }
      switch (Kind) {
       case ak_std_string:
        {
          /*const*/std.string/*&*/ S = getArgStdStr(ArgNo);
          assert (ModifierLen == 0) : diagJava.$name(DiagObj.CurDiagID) + " No modifiers for strings yet";
          OutStr.append(S);
          break;
        }
       case ak_c_string:
        {
          /*const*/char$ptr/*char P*/ S = $tryClone(getArgCStr(ArgNo));
          assert (ModifierLen == 0) : diagJava.$name(DiagObj.CurDiagID) + " No modifiers for strings yet";
          
          // Don't crash if get passed a null pointer by accident.
          if (!(S != null)) {
            S = $tryClone($("(null)"));
          }
          
          OutStr.append(S, strlen(S));
          break;
        }
       case ak_sint:
        {
          int Val = getArgSInt(ArgNo);
          if (ModifierIs(Modifier, ModifierLen, "select")) {
            HandleSelectModifier(/*Deref*/this, (/*uint*/int)Val, Argument, ArgumentLen, 
                OutStr);
          } else if (ModifierIs(Modifier, ModifierLen, "s")) {
            HandleIntegerSModifier(Val, OutStr);
          } else if (ModifierIs(Modifier, ModifierLen, "plural")) {
            HandlePluralModifier(/*Deref*/this, (/*uint*/int)Val, Argument, ArgumentLen, 
                OutStr);
          } else if (ModifierIs(Modifier, ModifierLen, "ordinal")) {
            HandleOrdinalModifier((/*uint*/int)Val, OutStr);
          } else {
            assert (ModifierLen == 0) : diagJava.$name(DiagObj.CurDiagID) + " Unknown integer modifier";
            $c$.clean($c$.track(new raw_svector_ostream(OutStr)).$out_int(Val));
          }
          break;
        }
       case ak_uint:
        {
          /*uint*/int Val = getArgUInt(ArgNo);
          if (ModifierIs(Modifier, ModifierLen, "select")) {
            HandleSelectModifier(/*Deref*/this, Val, Argument, ArgumentLen, OutStr);
          } else if (ModifierIs(Modifier, ModifierLen, "s")) {
            HandleIntegerSModifier(Val, OutStr);
          } else if (ModifierIs(Modifier, ModifierLen, "plural")) {
            HandlePluralModifier(/*Deref*/this, (/*uint*/int)Val, Argument, ArgumentLen, 
                OutStr);
          } else if (ModifierIs(Modifier, ModifierLen, "ordinal")) {
            HandleOrdinalModifier(Val, OutStr);
          } else {
            assert (ModifierLen == 0) : diagJava.$name(DiagObj.CurDiagID) + " Unknown integer modifier";
            $c$.clean($c$.track(new raw_svector_ostream(OutStr)).$out_uint(Val));
          }
          break;
        }
       case ak_tokenkind:
        {
          raw_svector_ostream Out = null;
          try {
            /*tok.TokenKind*/char Kind1 = $int2ushort(((/*static_cast*//*tok.TokenKind*/Number)(getRawArg(ArgNo))).intValue());
            assert (ModifierLen == 0) : diagJava.$name(DiagObj.CurDiagID) + " No modifiers for token kinds yet";
            
            Out/*J*/= new raw_svector_ostream(OutStr);
            {
              /*const*/char$ptr/*char P*/ S = $tryClone(tok.getPunctuatorSpelling(Kind1));
              if ((S != null)) {
                // Quoted token spelling for punctuators.
                Out.$out_char($$SGL_QUOTE).$out(S).$out_char($$SGL_QUOTE);
              } else {
                S = $tryClone(tok.getKeywordSpelling(Kind1));
                if ((S != null)) {
                  // Unquoted token spelling for keywords.
                  Out.$out(S);
                } else {
                  S = $tryClone(getTokenDescForDiagnostic(Kind1));
                  if ((S != null)) {
                    // Unquoted translatable token name.
                    Out.$out(S);
                  } else {
                    S = $tryClone(tok.getTokenName(Kind1));
                    if ((S != null)) {
                      // Debug name, shouldn't appear in user-facing diagnostics.
                      Out.$out_char($$LT).$out(S).$out_char($$GT);
                    } else {
                      Out.$out("(null)");
                    }
                  }
                }
              }
            }
            break;
          } finally {
            if (Out != null) { Out.$destroy(); }
          }
        }
       case ak_identifierinfo:
        {
          /*const*/ IdentifierInfo /*P*/ II = getArgIdentifier(ArgNo);
          assert (ModifierLen == 0) : diagJava.$name(DiagObj.CurDiagID) + " No modifiers for strings yet";
          
          // Don't crash if get passed a null pointer by accident.
          if (!(II != null)) {
            /*const*/String/*char P*/ S = "(null)";
            OutStr.append(S);
            continue;
          }
          
          $c$.clean($c$.track(new raw_svector_ostream(OutStr)).$out_char($$SGL_QUOTE).$out(II.getName()).$out_char($$SGL_QUOTE));
          break;
        }
       case ak_qualtype:
       case ak_declarationname:
       case ak_nameddecl:
       case ak_nestednamespec:
       case ak_declcontext:
       case ak_attr:
        getDiags().ConvertArgToString(Kind, getRawArg(ArgNo), 
            new StringRef(Modifier, ModifierLen), 
            new StringRef(Argument, ArgumentLen), 
            new ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/> >(FormattedArgs), 
            OutStr, new ArrayRef<Object/*intptr_t*/>(QualTypeVals));
        break;
       case ak_qualtype_pair:
        // Create a struct with all the info needed for printing.
        TemplateDiffTypes TDT/*J*/= new TemplateDiffTypes();
        TDT.FromType = getRawArg(ArgNo);
        TDT.ToType = getRawArg(ArgNo2);
        TDT.ElideType = getDiags().ElideType;
        TDT.ShowColors = getDiags().ShowColors;
        TDT.TemplateDiffUsed = false;
        Object/*intptr_t*/ val = reinterpret_cast_Object/*intptr_t*/($AddrOf(TDT));
        
        /*const*/char$ptr/*char P*/ ArgumentEnd = $tryClone(Argument.$add(ArgumentLen));
        /*const*/char$ptr/*char P*/ Pipe = $tryClone(ScanFormat(Argument, ArgumentEnd, $$PIPE));
        
        // Print the tree.  If this diagnostic already has a tree, skip the
        // second tree.
        if (getDiags().PrintTemplateTree && Tree.empty()) {
          TDT.PrintFromType = true;
          TDT.PrintTree = true;
          getDiags().ConvertArgToString(Kind, val, 
              new StringRef(Modifier, ModifierLen), 
              new StringRef(Argument, ArgumentLen), 
              new ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/> >(FormattedArgs), 
              Tree, new ArrayRef<Object/*intptr_t*/>(QualTypeVals));
          // If there is no tree information, fall back to regular printing.
          if (!Tree.empty()) {
            FormatDiagnostic(Pipe.$add(1), ArgumentEnd, OutStr);
            break;
          }
        }
        
        // Non-tree printing, also the fall-back when tree printing fails.
        // The fall-back is triggered when the types compared are not templates.
        /*const*/char$ptr/*char P*/ FirstDollar = $tryClone(ScanFormat(Argument, ArgumentEnd, $$DOLLAR));
        /*const*/char$ptr/*char P*/ SecondDollar = $tryClone(ScanFormat(FirstDollar.$add(1), ArgumentEnd, $$DOLLAR));
        
        // Append before text
        FormatDiagnostic(Argument, FirstDollar, OutStr);
        
        // Append first type
        TDT.PrintTree = false;
        TDT.PrintFromType = true;
        getDiags().ConvertArgToString(Kind, val, 
            new StringRef(Modifier, ModifierLen), 
            new StringRef(Argument, ArgumentLen), 
            new ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/> >(FormattedArgs), 
            OutStr, new ArrayRef<Object/*intptr_t*/>(QualTypeVals));
        if (!TDT.TemplateDiffUsed) {
          FormattedArgs.push_back(std.make_pair(DiagnosticsEngine.ArgumentKind.ak_qualtype, 
                  TDT.FromType));
        }
        
        // Append middle text
        FormatDiagnostic(FirstDollar.$add(1), SecondDollar, OutStr);
        
        // Append second type
        TDT.PrintFromType = false;
        getDiags().ConvertArgToString(Kind, val, 
            new StringRef(Modifier, ModifierLen), 
            new StringRef(Argument, ArgumentLen), 
            new ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/> >(FormattedArgs), 
            OutStr, new ArrayRef<Object/*intptr_t*/>(QualTypeVals));
        if (!TDT.TemplateDiffUsed) {
          FormattedArgs.push_back(std.make_pair(DiagnosticsEngine.ArgumentKind.ak_qualtype, 
                  TDT.ToType));
        }
        
        // Append end text
        FormatDiagnostic(SecondDollar.$add(1), Pipe, OutStr);
        break;
      }
      
      // Remember this argument info for subsequent formatting operations.  Turn
      // std::strings into a null terminated string to make it be the same case as
      // all the other ones.
      if (Kind == DiagnosticsEngine.ArgumentKind.ak_qualtype_pair) {
        continue;
      } else if (Kind != DiagnosticsEngine.ArgumentKind.ak_std_string) {
        FormattedArgs.push_back(std.make_pair(Kind, getRawArg(ArgNo)));
      } else {
        FormattedArgs.push_back(std.make_pair(DiagnosticsEngine.ArgumentKind.ak_c_string, 
                (Object/*intptr_t*/)getArgStdStr(ArgNo).c_str()));
      }
    }
    
    // Append the type tree to the end of the diagnostics.
    OutStr.append_T(Tree.begin(), Tree.end());
  } finally {
    $c$.$destroy();
  }
}

  @Override
  public String toString() {
    return "Diagnostic{" + StoredDiagMessage + '}';
  }  
}
