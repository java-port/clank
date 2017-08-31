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
package org.clang.frontend.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.frontend.*;
import org.llvm.bitcode.*;
import org.llvm.bitcode.bitc.*;


//<editor-fold defaultstate="collapsed" desc="static type SerializedDiagnosticPrinterStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZL11EmitBlockIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE;_ZL12EmitRecordIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE;_ZL14getStableLevelN5clang17DiagnosticsEngine5LevelE;_ZL22AddRangeLocationAbbrevPN4llvm13BitCodeAbbrevE;_ZL23AddSourceLocationAbbrevPN4llvm13BitCodeAbbrevE; -static-type=SerializedDiagnosticPrinterStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class SerializedDiagnosticPrinterStatics {

// end namespace clang

//===----------------------------------------------------------------------===//
// Serialization methods.
//===----------------------------------------------------------------------===//

/// \brief Emits a block ID in the BLOCKINFO block.
//<editor-fold defaultstate="collapsed" desc="EmitBlockID">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 324,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 323,
 FQN="EmitBlockID", NM="_ZL11EmitBlockIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZL11EmitBlockIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE")
//</editor-fold>
public static void EmitBlockID(/*uint*/int ID, /*const*/char$ptr/*char P*/ Name, 
           BitstreamWriter /*&*/ Stream, 
           SmallVectorImplULong /*&*/ Record) {
  Record.clear();
  Record.push_back($uint2ullong(ID));
  Stream.EmitRecord(BlockInfoCodes.BLOCKINFO_CODE_SETBID.getValue(), Record);
  
  // Emit the block name if present.
  if (!(Name != null) || Name.$at(0) == 0) {
    return;
  }
  
  Record.clear();
  Name = Native.$tryClone(Name);
  while ((Name.$star() != 0)) {
    Record.push_back($char2ullong(Name.$postInc().$star()));
  }
  
  Stream.EmitRecord(BlockInfoCodes.BLOCKINFO_CODE_BLOCKNAME.getValue(), Record);
}


/// \brief Emits a record ID in the BLOCKINFO block.
//<editor-fold defaultstate="collapsed" desc="EmitRecordID">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 344,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 343,
 FQN="EmitRecordID", NM="_ZL12EmitRecordIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZL12EmitRecordIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE")
//</editor-fold>
public static void EmitRecordID(/*uint*/int ID, /*const*/char$ptr/*char P*/ Name, 
            BitstreamWriter /*&*/ Stream, 
            SmallVectorImplULong /*&*/ Record) {
  Record.clear();
  Record.push_back($uint2ullong(ID));
  Name = Native.$tryClone(Name);
  while ((Name.$star() != 0)) {
    Record.push_back($char2ullong(Name.$postInc().$star()));
  }
  
  Stream.EmitRecord(BlockInfoCodes.BLOCKINFO_CODE_SETRECORDNAME.getValue(), Record);
}

//<editor-fold defaultstate="collapsed" desc="AddSourceLocationAbbrev">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 428,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 427,
 FQN="AddSourceLocationAbbrev", NM="_ZL23AddSourceLocationAbbrevPN4llvm13BitCodeAbbrevE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZL23AddSourceLocationAbbrevPN4llvm13BitCodeAbbrevE")
//</editor-fold>
public static void AddSourceLocationAbbrev(BitCodeAbbrev /*P*/ Abbrev) {
  //JAVA: using namespace llvm;
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 10)); // File ID.
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 32)); // Line.
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 32)); // Column.
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 32)); // Offset;
}

//<editor-fold defaultstate="collapsed" desc="AddRangeLocationAbbrev">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 436,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 435,
 FQN="AddRangeLocationAbbrev", NM="_ZL22AddRangeLocationAbbrevPN4llvm13BitCodeAbbrevE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZL22AddRangeLocationAbbrevPN4llvm13BitCodeAbbrevE")
//</editor-fold>
public static void AddRangeLocationAbbrev(BitCodeAbbrev /*P*/ Abbrev) {
  AddSourceLocationAbbrev(Abbrev);
  AddSourceLocationAbbrev(Abbrev);
}

//<editor-fold defaultstate="collapsed" desc="getStableLevel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 632,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 631,
 FQN="getStableLevel", NM="_ZL14getStableLevelN5clang17DiagnosticsEngine5LevelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZL14getStableLevelN5clang17DiagnosticsEngine5LevelE")
//</editor-fold>
public static serialized_diags.Level getStableLevel(DiagnosticsEngine.Level Level) {
  switch (Level) {
   case Ignored:
    return serialized_diags.Level.Ignored;
   case Note:
    return serialized_diags.Level.Note;
   case Remark:
    return serialized_diags.Level.Remark;
   case Warning:
    return serialized_diags.Level.Warning;
   case Error:
    return serialized_diags.Level.Error;
   case Fatal:
    return serialized_diags.Level.Fatal;
  }
  throw new llvm_unreachable("invalid diagnostic level");
}

} // END OF class SerializedDiagnosticPrinterStatics
