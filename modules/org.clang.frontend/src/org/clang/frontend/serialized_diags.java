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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.frontend.*;
import org.llvm.bitcode.bitc.*;
import org.llvm.bitcode.*;


//<editor-fold defaultstate="collapsed" desc="static type serialized_diags">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZN5clang16serialized_diags15SDErrorCategoryEv;_ZN5clang16serialized_diags15make_error_codeENS0_7SDErrorE;_ZN5clang16serialized_diags26SerializedDiagnosticReaderE;_ZN5clang16serialized_diags5LevelE;_ZN5clang16serialized_diags6createEN4llvm9StringRefEPNS_17DiagnosticOptionsEb;_ZN5clang16serialized_diags7SDErrorE;_ZN5clang16serialized_diags8BlockIDsE;_ZN5clang16serialized_diags8LocationE;_ZN5clang16serialized_diags9RecordIDsE;_ZN5clang16serialized_diagsE_SerializedDiagnostics_h_Unnamed_enum3; -static-type=serialized_diags -package=org.clang.frontend")
//</editor-fold>
public final class serialized_diags {

//<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::BlockIDs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnostics.h", line = 18,
 FQN="clang::serialized_diags::BlockIDs", NM="_ZN5clang16serialized_diags8BlockIDsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags8BlockIDsE")
//</editor-fold>
public static final class/*enum*/ BlockIDs {
  /// \brief A top-level block which represents any meta data associated
  /// with the diagostics, including versioning of the format.
  public static final int BLOCK_META = StandardBlockIDs.FIRST_APPLICATION_BLOCKID;
  
  /// \brief The this block acts as a container for all the information
  /// for a specific diagnostic.
  public static final int BLOCK_DIAG = BLOCK_META + 1;
}
//<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::RecordIDs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnostics.h", line = 28,
 FQN="clang::serialized_diags::RecordIDs", NM="_ZN5clang16serialized_diags9RecordIDsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags9RecordIDsE")
//</editor-fold>
public enum RecordIDs implements Native.ComparableLower {
  RECORD_VERSION(1),
  RECORD_DIAG(RECORD_VERSION.getValue() + 1),
  RECORD_SOURCE_RANGE(RECORD_DIAG.getValue() + 1),
  RECORD_DIAG_FLAG(RECORD_SOURCE_RANGE.getValue() + 1),
  RECORD_CATEGORY(RECORD_DIAG_FLAG.getValue() + 1),
  RECORD_FILENAME(RECORD_CATEGORY.getValue() + 1),
  RECORD_FIXIT(RECORD_FILENAME.getValue() + 1),
  RECORD_FIRST(RecordIDs.RECORD_VERSION.getValue()),
  RECORD_LAST(RecordIDs.RECORD_FIXIT.getValue());

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static RecordIDs valueOf(int val) {
    RecordIDs out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final RecordIDs[] VALUES;
    private static final RecordIDs[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (RecordIDs kind : RecordIDs.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new RecordIDs[min < 0 ? (1-min) : 0];
      VALUES = new RecordIDs[max >= 0 ? (1+max) : 0];
      for (RecordIDs kind : RecordIDs.values()) {
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
  private RecordIDs(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((RecordIDs)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((RecordIDs)obj).value);}
  //</editor-fold>
}

/// \brief A stable version of DiagnosticIDs::Level.
///
/// Do not change the order of values in this enum, and please increment the
/// serialized diagnostics version number when you add to it.
//<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::Level">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnostics.h", line = 44,
 FQN="clang::serialized_diags::Level", NM="_ZN5clang16serialized_diags5LevelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags5LevelE")
//</editor-fold>
public enum Level implements Native.ComparableLower {
  Ignored(0),
  Note(Ignored.getValue() + 1),
  Warning(Note.getValue() + 1),
  Error(Warning.getValue() + 1),
  Fatal(Error.getValue() + 1),
  Remark(Fatal.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static Level valueOf(int val) {
    Level out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final Level[] VALUES;
    private static final Level[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (Level kind : Level.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new Level[min < 0 ? (1-min) : 0];
      VALUES = new Level[max >= 0 ? (1+max) : 0];
      for (Level kind : Level.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private Level(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Level)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Level)obj).value);}
  //</editor-fold>
}

/// \brief The serialized diagnostics version number.
//<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnostics.h", line = 54,
 FQN="clang::serialized_diags::(anonymous)", NM="_ZN5clang16serialized_diagsE_SerializedDiagnostics_h_Unnamed_enum3",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diagsE_SerializedDiagnostics_h_Unnamed_enum3")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int VersionNumber = 2;
/*}*/

/// \brief Returns a DiagnosticConsumer that serializes diagnostics to
///  a bitcode file.
///
/// The created DiagnosticConsumer is designed for quick and lightweight
/// transfer of of diagnostics to the enclosing build system (e.g., an IDE).
/// This allows wrapper tools for Clang to get diagnostics from Clang
/// (via libclang) without needing to parse Clang's command line output.
///
//<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::create">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 311,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 310,
 FQN="clang::serialized_diags::create", NM="_ZN5clang16serialized_diags6createEN4llvm9StringRefEPNS_17DiagnosticOptionsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags6createEN4llvm9StringRefEPNS_17DiagnosticOptionsEb")
//</editor-fold>
public static std.unique_ptr<DiagnosticConsumer> create(StringRef OutputFile, DiagnosticOptions /*P*/ Diags) {
  return create(OutputFile, Diags, false);
}
public static std.unique_ptr<DiagnosticConsumer> create(StringRef OutputFile, DiagnosticOptions /*P*/ Diags, boolean MergeChildRecords/*= false*/) {
  return /*delegate*/org.clang.frontend.impl.SerializedDiagnosticPrinterSerialized_diagsGlobals.
    create(OutputFile, Diags, MergeChildRecords);
}

//<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SDError">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*implements is_error_code_enum*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 21,
 FQN="clang::serialized_diags::SDError", NM="_ZN5clang16serialized_diags7SDErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags7SDErrorE")
//</editor-fold>
public enum /*class */SDError/* : int*/ implements Native.ComparableLower, is_error_code_enum {
  CouldNotLoad(1),
  InvalidSignature(CouldNotLoad.getValue() + 1),
  InvalidDiagnostics(InvalidSignature.getValue() + 1),
  MalformedTopLevelBlock(InvalidDiagnostics.getValue() + 1),
  MalformedSubBlock(MalformedTopLevelBlock.getValue() + 1),
  MalformedBlockInfoBlock(MalformedSubBlock.getValue() + 1),
  MalformedMetadataBlock(MalformedBlockInfoBlock.getValue() + 1),
  MalformedDiagnosticBlock(MalformedMetadataBlock.getValue() + 1),
  MalformedDiagnosticRecord(MalformedDiagnosticBlock.getValue() + 1),
  MissingVersion(MalformedDiagnosticRecord.getValue() + 1),
  VersionMismatch(MissingVersion.getValue() + 1),
  UnsupportedConstruct(VersionMismatch.getValue() + 1),
  /// A generic error for subclass handlers that don't want or need to define
  /// their own error_category.
  HandlerFailed(UnsupportedConstruct.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static SDError valueOf(int val) {
    SDError out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final SDError[] VALUES;
    private static final SDError[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (SDError kind : SDError.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new SDError[min < 0 ? (1-min) : 0];
      VALUES = new SDError[max >= 0 ? (1+max) : 0];
      for (SDError kind : SDError.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private SDError(int val) { this.value = (int)val;}
  public int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((SDError)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((SDError)obj).value);}
  //</editor-fold>
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override public std_errors.error_category getCategory() {
    return SDErrorCategory();
  }
  
  }
//<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::make_error_code">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 41,
 FQN="clang::serialized_diags::make_error_code", NM="_ZN5clang16serialized_diags15make_error_codeENS0_7SDErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags15make_error_codeENS0_7SDErrorE")
//</editor-fold>
public static /*inline*/ std.error_code make_error_code(SDError E) {
  return /*delegate*/org.clang.frontend.impl.SerializedDiagnosticReaderSerialized_diagsGlobals.
    make_error_code(E);
}


/// \brief A location that is represented in the serialized diagnostics.
//<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::Location">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 46,
 FQN="clang::serialized_diags::Location", NM="_ZN5clang16serialized_diags8LocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags8LocationE")
//</editor-fold>
public static class/*struct*/ Location {
  public /*uint*/int FileID;
  public /*uint*/int Line;
  public /*uint*/int Col;
  public /*uint*/int Offset;
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::Location::Location">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 51,
   FQN="clang::serialized_diags::Location::Location", NM="_ZN5clang16serialized_diags8LocationC1Ejjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags8LocationC1Ejjjj")
  //</editor-fold>
  public Location(/*uint*/int FileID, /*uint*/int Line, /*uint*/int Col, /*uint*/int Offset) {
    // : FileID(FileID), Line(Line), Col(Col), Offset(Offset) 
    //START JInit
    this.FileID = FileID;
    this.Line = Line;
    this.Col = Col;
    this.Offset = Offset;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::Location::~Location">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 46,
   FQN="clang::serialized_diags::Location::~Location", NM="_ZN5clang16serialized_diags8LocationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZN5clang16serialized_diags8LocationD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
  }

  
  @Override public String toString() {
    return "" + "FileID=" + FileID // NOI18N
              + ", Line=" + Line // NOI18N
              + ", Col=" + Col // NOI18N
              + ", Offset=" + Offset; // NOI18N
  }
}

/// \brief A base class that handles reading serialized diagnostics from a file.
///
/// Subclasses should override the visit* methods with their logic for handling
/// the various constructs that are found in serialized diagnostics.
//<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 59,
 FQN="clang::serialized_diags::SerializedDiagnosticReader", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReaderE")
//</editor-fold>
public static class SerializedDiagnosticReader implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::SerializedDiagnosticReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 61,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::SerializedDiagnosticReader", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReaderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReaderC1Ev")
  //</editor-fold>
  public SerializedDiagnosticReader() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::~SerializedDiagnosticReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 62,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::~SerializedDiagnosticReader", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReaderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReaderD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  /// \brief Read the diagnostics in \c File
  
  /// \brief Read the diagnostics in \c File
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::readDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp", line = 19,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::readDiagnostics", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader15readDiagnosticsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader15readDiagnosticsEN4llvm9StringRefE")
  //</editor-fold>
  public std.error_code readDiagnostics(StringRef File) {
    FileManager FileMgr = null;
    ErrorOr<unique_ptr<MemoryBuffer> > Buffer = null;
    BitstreamReader StreamFile = null;
    BitstreamCursor Stream = null;
    try {
      // Open the diagnostics file.
      FileSystemOptions FO/*J*/= new FileSystemOptions();
      FileMgr/*J*/= new FileManager(FO);
      
      Buffer = FileMgr.getBufferForFile(new StringRef(File));
      if (!Buffer.$bool()) {
        return new std.error_code(SDError.CouldNotLoad);
      }
      
      StreamFile/*J*/= new BitstreamReader();
      StreamFile.init(reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, (Buffer.$star()).$arrow().getBufferStart()), 
          reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, (Buffer.$star()).$arrow().getBufferEnd()));
      
      Stream/*J*/= new BitstreamCursor(StreamFile);
      
      // Sniff for the signature.
      if (Stream.Read(8) != $$D
         || Stream.Read(8) != $$I
         || Stream.Read(8) != $$A
         || Stream.Read(8) != $$G) {
        return new std.error_code(SDError.InvalidSignature);
      }
      
      // Read the top level blocks.
      while (!Stream.AtEndOfStream()) {
        if (Stream.ReadCode() != FixedAbbrevIDs.ENTER_SUBBLOCK) {
          return new std.error_code(SDError.InvalidDiagnostics);
        }
        
        std.error_code EC/*J*/= new std.error_code();
        switch (Stream.ReadSubBlockID()) {
         case StandardBlockIDs.BLOCKINFO_BLOCK_ID:
          if (Stream.ReadBlockInfoBlock()) {
            return new std.error_code(SDError.MalformedBlockInfoBlock);
          }
          continue;
         case BlockIDs.BLOCK_META:
          if ((EC.$assignMove(readMetaBlock(Stream))).$bool()) {
            return EC;
          }
          continue;
         case BlockIDs.BLOCK_DIAG:
          if ((EC.$assignMove(readDiagnosticBlock(Stream))).$bool()) {
            return EC;
          }
          continue;
         default:
          if (!Stream.SkipBlock()) {
            return new std.error_code(SDError.MalformedTopLevelBlock);
          }
          continue;
        }
      }
      return new std.error_code();
    } finally {
      if (Stream != null) { Stream.$destroy(); }
      if (StreamFile != null) { StreamFile.$destroy(); }
      if (Buffer != null) { Buffer.$destroy(); }
      if (FileMgr != null) { FileMgr.$destroy(); }
    }
  }


/*private:*/
  /*enum class Cursor : int*/ /*NO BODY FOUND*/;
  //  enum class Cursor;
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::Cursor">
  @Converted(kind = Converted.Kind.MANUAL_ADDED/*why not generated??*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 69,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", old_line = 68,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::Cursor", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader6CursorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader6CursorE")
  //</editor-fold>
  private enum /*class */Cursor/* : int*/ implements Native.ComparableLower {
    Record(1),
    BlockEnd(Record.getValue() + 1),
    BlockBegin(BlockEnd.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Cursor valueOf(int val) {
      Cursor out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Cursor[] VALUES;
      private static final Cursor[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Cursor kind : Cursor.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Cursor[min < 0 ? (1-min) : 0];
        VALUES = new Cursor[max >= 0 ? (1+max) : 0];
        for (Cursor kind : Cursor.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private Cursor(int val) { this.value = (int)val;}
    public int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((Cursor)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((Cursor)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Read to the next record or block to process.
  
  /// \brief Read to the next record or block to process.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::skipUntilRecordOrBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp", line = 75,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::skipUntilRecordOrBlock", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader22skipUntilRecordOrBlockERN4llvm15BitstreamCursorERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader22skipUntilRecordOrBlockERN4llvm15BitstreamCursorERj")
  //</editor-fold>
  private ErrorOr<SerializedDiagnosticReader.Cursor> skipUntilRecordOrBlock(BitstreamCursor /*&*/ Stream, uint$ref/*uint &*/ BlockOrRecordID) {
    BlockOrRecordID.$set(0);
    while (!Stream.AtEndOfStream()) {
      /*uint*/int Code = Stream.ReadCode();
      switch (Code) {
       case FixedAbbrevIDs.ENTER_SUBBLOCK:
        BlockOrRecordID.$set(Stream.ReadSubBlockID());
        return new ErrorOr<SerializedDiagnosticReader.Cursor>(JD$Convertible.INSTANCE, Cursor.BlockBegin);
       case FixedAbbrevIDs.END_BLOCK:
        if (Stream.ReadBlockEnd()) {
          return new ErrorOr<SerializedDiagnosticReader.Cursor>(JD$IsErrorCodeOrErrorCondition.INSTANCE, SDError.InvalidDiagnostics);
        }
        return new ErrorOr<SerializedDiagnosticReader.Cursor>(JD$Convertible.INSTANCE, Cursor.BlockEnd);
       case FixedAbbrevIDs.DEFINE_ABBREV:
        Stream.ReadAbbrevRecord();
        continue;
       case FixedAbbrevIDs.UNABBREV_RECORD:
        return new ErrorOr<SerializedDiagnosticReader.Cursor>(JD$IsErrorCodeOrErrorCondition.INSTANCE, SDError.UnsupportedConstruct);
       default:
        // We found a record.
        BlockOrRecordID.$set(Code);
        return new ErrorOr<SerializedDiagnosticReader.Cursor>(JD$Convertible.INSTANCE, Cursor.Record);
      }
    }
    
    return new ErrorOr<SerializedDiagnosticReader.Cursor>(JD$IsErrorCodeOrErrorCondition.INSTANCE, SDError.InvalidDiagnostics);
  }


  
  /// \brief Read a metadata block from \c Stream.
  
  /// \brief Read a metadata block from \c Stream.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::readMetaBlock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp", line = 110,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::readMetaBlock", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader13readMetaBlockERN4llvm15BitstreamCursorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader13readMetaBlockERN4llvm15BitstreamCursorE")
  //</editor-fold>
  private std.error_code readMetaBlock(BitstreamCursor /*&*/ Stream) {
    if (Stream.EnterSubBlock(serialized_diags.BlockIDs.BLOCK_META)) {
      return new std.error_code(SDError.MalformedMetadataBlock);
    }
    
    boolean VersionChecked = false;
    while (true) {
      /*uint*/uint$ref BlockOrCode = create_uint$ref(0);
      ErrorOr<Cursor> Res = skipUntilRecordOrBlock(Stream, BlockOrCode);
      if (!Res.$bool()) {
        Res.getError();
      }
      switch (Res.get()) {
       case Record:
        break;
       case BlockBegin:
        if (Stream.SkipBlock()) {
          return new std.error_code(SDError.MalformedMetadataBlock);
        }
       case BlockEnd:
        if (!VersionChecked) {
          return new std.error_code(SDError.MissingVersion);
        }
        return new std.error_code();
      }
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(1, 0);
      /*uint*/int RecordID = Stream.readRecord(BlockOrCode.$deref(), Record);
      if (RecordID == RecordIDs.RECORD_VERSION.getValue()) {
        if ($less_uint(Record.size(), 1)) {
          return new std.error_code(SDError.MissingVersion);
        }
        if ($greater_ullong_uint(Record.$at(0), VersionNumber)) {
          return new std.error_code(SDError.VersionMismatch);
        }
        VersionChecked = true;
      }
    }
  }


  
  /// \brief Read a diagnostic block from \c Stream.
  
  /// \brief Read a diagnostic block from \c Stream.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::readDiagnosticBlock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp", line = 148,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::readDiagnosticBlock", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader19readDiagnosticBlockERN4llvm15BitstreamCursorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader19readDiagnosticBlockERN4llvm15BitstreamCursorE")
  //</editor-fold>
  private std.error_code readDiagnosticBlock(BitstreamCursor /*&*/ Stream) {
    if (Stream.EnterSubBlock(serialized_diags.BlockIDs.BLOCK_DIAG)) {
      return new std.error_code(SDError.MalformedDiagnosticBlock);
    }
    
    std.error_code EC/*J*/= new std.error_code();
    if ((EC.$assignMove(visitStartOfDiagnostic())).$bool()) {
      return EC;
    }
    
    SmallVectorULong Record/*J*/= new SmallVectorULong(16, 0);
    while (true) {
      /*uint*/uint$ref BlockOrCode = create_uint$ref(0);
      ErrorOr<Cursor> Res = skipUntilRecordOrBlock(Stream, BlockOrCode);
      if (!Res.$bool()) {
        Res.getError();
      }
      switch (Res.get()) {
       case BlockBegin:
        // The only blocks we care about are subdiagnostics.
        if (BlockOrCode.$deref() == serialized_diags.BlockIDs.BLOCK_DIAG) {
          if ((EC.$assignMove(readDiagnosticBlock(Stream))).$bool()) {
            return EC;
          }
        } else if (!Stream.SkipBlock()) {
          return new std.error_code(SDError.MalformedSubBlock);
        }
        continue;
       case BlockEnd:
        if ((EC.$assignMove(visitEndOfDiagnostic())).$bool()) {
          return EC;
        }
        return new std.error_code();
       case Record:
        break;
      }
      
      // Read the record.
      Record.clear();
      StringRef Blob/*J*/= new StringRef();
      /*uint*/int RecID = Stream.readRecord(BlockOrCode.$deref(), Record, /*AddrOf*/Blob);
      if ($less_uint(RecID, serialized_diags.RecordIDs.RECORD_FIRST.getValue())
         || $greater_uint(RecID, serialized_diags.RecordIDs.RECORD_LAST.getValue())) {
        continue;
      }
      switch (RecordIDs.valueOf(RecID)) {
       case RECORD_CATEGORY:
        // A category has ID and name size.
        if (Record.size() != 2) {
          return new std.error_code(SDError.MalformedDiagnosticRecord);
        }
        if ((EC.$assignMove(visitCategoryRecord($ullong2uint(Record.$at(0)), new StringRef(Blob)))).$bool()) {
          return EC;
        }
        continue;
       case RECORD_DIAG:
        // A diagnostic has severity, location (4), category, flag, and message
        // size.
        if (Record.size() != 8) {
          return new std.error_code(SDError.MalformedDiagnosticRecord);
        }
        if ((EC.$assignMove(visitDiagnosticRecord($ullong2uint(Record.$at(0)), new Location($ullong2uint(Record.$at(1)), $ullong2uint(Record.$at(2)), $ullong2uint(Record.$at(3)), $ullong2uint(Record.$at(4))), 
                $ullong2uint(Record.$at(5)), $ullong2uint(Record.$at(6)), new StringRef(Blob)))).$bool()) {
          return EC;
        }
        continue;
       case RECORD_DIAG_FLAG:
        // A diagnostic flag has ID and name size.
        if (Record.size() != 2) {
          return new std.error_code(SDError.MalformedDiagnosticRecord);
        }
        if ((EC.$assignMove(visitDiagFlagRecord($ullong2uint(Record.$at(0)), new StringRef(Blob)))).$bool()) {
          return EC;
        }
        continue;
       case RECORD_FILENAME:
        // A filename has ID, size, timestamp, and name size. The size and
        // timestamp are legacy fields that are always zero these days.
        if (Record.size() != 4) {
          return new std.error_code(SDError.MalformedDiagnosticRecord);
        }
        if ((EC.$assignMove(visitFilenameRecord($ullong2uint(Record.$at(0)), $ullong2uint(Record.$at(1)), $ullong2uint(Record.$at(2)), new StringRef(Blob)))).$bool()) {
          return EC;
        }
        continue;
       case RECORD_FIXIT:
        // A fixit has two locations (4 each) and message size.
        if (Record.size() != 9) {
          return new std.error_code(SDError.MalformedDiagnosticRecord);
        }
        if ((EC.$assignMove(visitFixitRecord(new Location($ullong2uint(Record.$at(0)), $ullong2uint(Record.$at(1)), $ullong2uint(Record.$at(2)), $ullong2uint(Record.$at(3))), 
                new Location($ullong2uint(Record.$at(4)), $ullong2uint(Record.$at(5)), $ullong2uint(Record.$at(6)), $ullong2uint(Record.$at(7))), new StringRef(Blob)))).$bool()) {
          return EC;
        }
        continue;
       case RECORD_SOURCE_RANGE:
        // A source range is two locations (4 each).
        if (Record.size() != 8) {
          return new std.error_code(SDError.MalformedDiagnosticRecord);
        }
        if ((EC.$assignMove(visitSourceRangeRecord(new Location($ullong2uint(Record.$at(0)), $ullong2uint(Record.$at(1)), $ullong2uint(Record.$at(2)), $ullong2uint(Record.$at(3))), 
                new Location($ullong2uint(Record.$at(4)), $ullong2uint(Record.$at(5)), $ullong2uint(Record.$at(6)), $ullong2uint(Record.$at(7)))))).$bool()) {
          return EC;
        }
        continue;
       case RECORD_VERSION:
        // A version is just a number.
        if (Record.size() != 1) {
          return new std.error_code(SDError.MalformedDiagnosticRecord);
        }
        if ((EC.$assignMove(visitVersionRecord($ullong2uint(Record.$at(0))))).$bool()) {
          return EC;
        }
        continue;
      }
    }
  }


/*protected:*/
  /// \brief Visit the start of a diagnostic block.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::visitStartOfDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 82,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::visitStartOfDiagnostic", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader22visitStartOfDiagnosticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader22visitStartOfDiagnosticEv")
  //</editor-fold>
  protected /*virtual*/ std.error_code visitStartOfDiagnostic() {
    return new std.error_code();
  }

  /// \brief Visit the end of a diagnostic block.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::visitEndOfDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 86,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::visitEndOfDiagnostic", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader20visitEndOfDiagnosticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader20visitEndOfDiagnosticEv")
  //</editor-fold>
  protected /*virtual*/ std.error_code visitEndOfDiagnostic() {
    return new std.error_code();
  }

  /// \brief Visit a category. This associates the category \c ID to a \c Name.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::visitCategoryRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 88,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::visitCategoryRecord", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader19visitCategoryRecordEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader19visitCategoryRecordEjN4llvm9StringRefE")
  //</editor-fold>
  protected /*virtual*/ std.error_code visitCategoryRecord(/*uint*/int ID, StringRef Name) {
    return new std.error_code();
  }

  /// \brief Visit a flag. This associates the flag's \c ID to a \c Name.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::visitDiagFlagRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 92,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::visitDiagFlagRecord", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader19visitDiagFlagRecordEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader19visitDiagFlagRecordEjN4llvm9StringRefE")
  //</editor-fold>
  protected /*virtual*/ std.error_code visitDiagFlagRecord(/*uint*/int ID, StringRef Name) {
    return new std.error_code();
  }

  /// \brief Visit a diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::visitDiagnosticRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 96,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::visitDiagnosticRecord", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader21visitDiagnosticRecordEjRKNS0_8LocationEjjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader21visitDiagnosticRecordEjRKNS0_8LocationEjjN4llvm9StringRefE")
  //</editor-fold>
  protected /*virtual*/ std.error_code visitDiagnosticRecord(/*uint*/int Severity, /*const*/ Location /*&*/ Location, 
                       /*uint*/int Category, /*uint*/int Flag, StringRef Message) {
    return new std.error_code();
  }

  /// \brief Visit a filename. This associates the file's \c ID to a \c Name.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::visitFilenameRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 102,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::visitFilenameRecord", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader19visitFilenameRecordEjjjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader19visitFilenameRecordEjjjN4llvm9StringRefE")
  //</editor-fold>
  protected /*virtual*/ std.error_code visitFilenameRecord(/*uint*/int ID, /*uint*/int Size, 
                     /*uint*/int Timestamp, 
                     StringRef Name) {
    return new std.error_code();
  }

  /// \brief Visit a fixit hint.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::visitFixitRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 108,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::visitFixitRecord", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader16visitFixitRecordERKNS0_8LocationES4_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader16visitFixitRecordERKNS0_8LocationES4_N4llvm9StringRefE")
  //</editor-fold>
  protected /*virtual*/ std.error_code visitFixitRecord(/*const*/ Location /*&*/ Start, /*const*/ Location /*&*/ End, StringRef Text) {
    return new std.error_code();
  }

  /// \brief Visit a source range.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::visitSourceRangeRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 113,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::visitSourceRangeRecord", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader22visitSourceRangeRecordERKNS0_8LocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader22visitSourceRangeRecordERKNS0_8LocationES4_")
  //</editor-fold>
  protected /*virtual*/ std.error_code visitSourceRangeRecord(/*const*/ Location /*&*/ Start, 
                        /*const*/ Location /*&*/ End) {
    return new std.error_code();
  }

  /// \brief Visit the version of the set of diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SerializedDiagnosticReader::visitVersionRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/SerializedDiagnosticReader.h", line = 118,
   FQN="clang::serialized_diags::SerializedDiagnosticReader::visitVersionRecord", NM="_ZN5clang16serialized_diags26SerializedDiagnosticReader18visitVersionRecordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN5clang16serialized_diags26SerializedDiagnosticReader18visitVersionRecordEj")
  //</editor-fold>
  protected /*virtual*/ std.error_code visitVersionRecord(/*uint*/int Version) {
    return new std.error_code();
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::serialized_diags::SDErrorCategory">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp", line = 293,
 FQN="clang::serialized_diags::SDErrorCategory", NM="_ZN5clang16serialized_diags15SDErrorCategoryEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp -nm=_ZN5clang16serialized_diags15SDErrorCategoryEv")
//</editor-fold>
public static /*const*/ std.error_category /*&*/ SDErrorCategory() {
  return /*delegate*/org.clang.frontend.impl.SerializedDiagnosticReaderSerialized_diagsGlobals.
    SDErrorCategory();
}

} // END OF class serialized_diags
