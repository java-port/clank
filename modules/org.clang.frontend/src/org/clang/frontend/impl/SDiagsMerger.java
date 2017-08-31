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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import org.clang.frontend.serialized_diags.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 99,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 98,
 FQN="(anonymous namespace)::SDiagsMerger", NM="_ZN12_GLOBAL__N_112SDiagsMergerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMergerE")
//</editor-fold>
public class SDiagsMerger extends /**/ SerializedDiagnosticReader implements Destructors.ClassWithDestructor {
  private SDiagsWriter /*&*/ Writer;
  private DenseMapUIntUInt FileLookup;
  private DenseMapUIntUInt CategoryLookup;
  private DenseMapUIntUInt DiagFlagLookup;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::SDiagsMerger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 106,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 105,
   FQN="(anonymous namespace)::SDiagsMerger::SDiagsMerger", NM="_ZN12_GLOBAL__N_112SDiagsMergerC1ERNS_12SDiagsWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMergerC1ERNS_12SDiagsWriterE")
  //</editor-fold>
  public SDiagsMerger(SDiagsWriter /*&*/ Writer) {
    // : SerializedDiagnosticReader(), Writer(Writer), FileLookup(), CategoryLookup(), DiagFlagLookup() 
    //START JInit
    super();
    this./*&*/Writer=/*&*/Writer;
    this.FileLookup = new DenseMapUIntUInt(DenseMapInfoUInt.$Info(), 0);
    this.CategoryLookup = new DenseMapUIntUInt(DenseMapInfoUInt.$Info(), 0);
    this.DiagFlagLookup = new DenseMapUIntUInt(DenseMapInfoUInt.$Info(), 0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::mergeRecordsFromFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 108,
   FQN="(anonymous namespace)::SDiagsMerger::mergeRecordsFromFile", NM="_ZN12_GLOBAL__N_112SDiagsMerger20mergeRecordsFromFileEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger20mergeRecordsFromFileEPKc")
  //</editor-fold>
  public std.error_code mergeRecordsFromFile(/*const*/char$ptr/*char P*/ File) {
    return readDiagnostics(new StringRef(File));
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::visitStartOfDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 824,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 823,
   FQN="(anonymous namespace)::SDiagsMerger::visitStartOfDiagnostic", NM="_ZN12_GLOBAL__N_112SDiagsMerger22visitStartOfDiagnosticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger22visitStartOfDiagnosticEv")
  //</editor-fold>
  @Override protected std.error_code visitStartOfDiagnostic()/* override*/ {
    Writer.EnterDiagBlock();
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::visitEndOfDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 829,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 828,
   FQN="(anonymous namespace)::SDiagsMerger::visitEndOfDiagnostic", NM="_ZN12_GLOBAL__N_112SDiagsMerger20visitEndOfDiagnosticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger20visitEndOfDiagnosticEv")
  //</editor-fold>
  @Override protected std.error_code visitEndOfDiagnostic()/* override*/ {
    Writer.ExitDiagBlock();
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::visitCategoryRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 879,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 878,
   FQN="(anonymous namespace)::SDiagsMerger::visitCategoryRecord", NM="_ZN12_GLOBAL__N_112SDiagsMerger19visitCategoryRecordEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger19visitCategoryRecordEjN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.error_code visitCategoryRecord(/*uint*/int ID, StringRef Name)/* override*/ {
    CategoryLookup.$set(ID, Writer.getEmitCategory(ID));
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::visitDiagFlagRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 884,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 883,
   FQN="(anonymous namespace)::SDiagsMerger::visitDiagFlagRecord", NM="_ZN12_GLOBAL__N_112SDiagsMerger19visitDiagFlagRecordEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger19visitDiagFlagRecordEjN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.error_code visitDiagFlagRecord(/*uint*/int ID, StringRef Name)/* override*/ {
    DiagFlagLookup.$set(ID, Writer.getEmitDiagnosticFlag(new StringRef(Name)));
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::visitDiagnosticRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 845,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 844,
   FQN="(anonymous namespace)::SDiagsMerger::visitDiagnosticRecord", NM="_ZN12_GLOBAL__N_112SDiagsMerger21visitDiagnosticRecordEjRKN5clang16serialized_diags8LocationEjjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger21visitDiagnosticRecordEjRKN5clang16serialized_diags8LocationEjjN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.error_code visitDiagnosticRecord(/*uint*/int Severity, /*const*/ serialized_diags.Location /*&*/ Location, 
                       /*uint*/int Category, /*uint*/int Flag, StringRef Message)/* override*/ {
    /*SmallVectorULong.value_type*/long Record[/*9*/] = new /*SmallVectorULong.value_type*/long [/*9*/] {
      RecordIDs.RECORD_DIAG.getValue(), $uint2ullong(Severity), $uint2ullong(FileLookup.$at(Location.FileID)), $uint2ullong(Location.Line), 
      $uint2ullong(Location.Col), $uint2ullong(Location.Offset), $uint2ullong(CategoryLookup.$at(Category)), 
      $uint2ullong((Flag != 0) ? DiagFlagLookup.$at(Flag) : 0), $uint2ullong(Message.size())};
    
    Writer.State.$arrow().Stream.EmitRecordWithBlob(Writer.State.$arrow().Abbrevs.get(RecordIDs.RECORD_DIAG.getValue()), Record, new StringRef(Message));
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::visitFilenameRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 872,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 871,
   FQN="(anonymous namespace)::SDiagsMerger::visitFilenameRecord", NM="_ZN12_GLOBAL__N_112SDiagsMerger19visitFilenameRecordEjjjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger19visitFilenameRecordEjjjN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.error_code visitFilenameRecord(/*uint*/int ID, /*uint*/int Size, 
                     /*uint*/int Timestamp, 
                     StringRef Name)/* override*/ {
    FileLookup.$set(ID, Writer.getEmitFile(Name.str().c_str()));
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::visitFixitRecord">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 858,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 857,
   FQN="(anonymous namespace)::SDiagsMerger::visitFixitRecord", NM="_ZN12_GLOBAL__N_112SDiagsMerger16visitFixitRecordERKN5clang16serialized_diags8LocationES5_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger16visitFixitRecordERKN5clang16serialized_diags8LocationES5_N4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.error_code visitFixitRecord(/*const*/ serialized_diags.Location /*&*/ Start, 
                  /*const*/ serialized_diags.Location /*&*/ End, 
                  StringRef Text)/* override*/ {
    /*SmallVectorULong.value_type*/long Record[/*10*/] = new /*SmallVectorULong.value_type*/long [/*10*/] {
      RecordIDs.RECORD_FIXIT.getValue(), $uint2ullong(FileLookup.$at(Start.FileID)), 
      $uint2ullong(Start.Line), $uint2ullong(Start.Col), $uint2ullong(Start.Offset), 
      $uint2ullong(FileLookup.$at(End.FileID)), $uint2ullong(End.Line), $uint2ullong(End.Col), 
      $uint2ullong(End.Offset), $uint2ullong(Text.size())};
    
    Writer.State.$arrow().Stream.EmitRecordWithBlob(Writer.State.$arrow().Abbrevs.get(RecordIDs.RECORD_FIXIT.getValue()), Record, new StringRef(Text));
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::visitSourceRangeRecord">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 834,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 833,
   FQN="(anonymous namespace)::SDiagsMerger::visitSourceRangeRecord", NM="_ZN12_GLOBAL__N_112SDiagsMerger22visitSourceRangeRecordERKN5clang16serialized_diags8LocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger22visitSourceRangeRecordERKN5clang16serialized_diags8LocationES5_")
  //</editor-fold>
  @Override protected std.error_code visitSourceRangeRecord(/*const*/ serialized_diags.Location /*&*/ Start, 
                        /*const*/ serialized_diags.Location /*&*/ End)/* override*/ {
    /*SmallVectorULong.value_type*/long Record[/*9*/] = new /*SmallVectorULong.value_type*/long [/*9*/] {
      RecordIDs.RECORD_SOURCE_RANGE.getValue(), $uint2ullong(FileLookup.$at(Start.FileID)), $uint2ullong(Start.Line), $uint2ullong(Start.Col), 
      $uint2ullong(Start.Offset), $uint2ullong(FileLookup.$at(End.FileID)), $uint2ullong(End.Line), $uint2ullong(End.Col), $uint2ullong(End.Offset)};
    Writer.State.$arrow().Stream.EmitRecordWithAbbrev(Writer.State.$arrow().Abbrevs.get(RecordIDs.RECORD_SOURCE_RANGE.getValue()), Record);
    return new std.error_code();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::adjustSourceLocFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 132,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 131,
   FQN="(anonymous namespace)::SDiagsMerger::adjustSourceLocFilename", NM="_ZN12_GLOBAL__N_112SDiagsMerger23adjustSourceLocFilenameERN4llvm11SmallVectorIyLj64EEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger23adjustSourceLocFilenameERN4llvm11SmallVectorIyLj64EEEj")
  //</editor-fold>
  private std.error_code adjustSourceLocFilename(SmallVectorULong /*&*/ Record, 
                         /*uint*/int offset) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::adjustAbbrevID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 135,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 134,
   FQN="(anonymous namespace)::SDiagsMerger::adjustAbbrevID", NM="_ZN12_GLOBAL__N_112SDiagsMerger14adjustAbbrevIDERN4llvm11SmallVectorIyLj64EEERNS1_8DenseMapIjjNS1_12DenseMapInfoIjEENS1_6detail12DenseMapPairIjjEEEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger14adjustAbbrevIDERN4llvm11SmallVectorIyLj64EEERNS1_8DenseMapIjjNS1_12DenseMapInfoIjEENS1_6detail12DenseMapPairIjjEEEEj")
  //</editor-fold>
  private void adjustAbbrevID(SmallVectorULong /*&*/ Record, DenseMapUIntUInt/*&*/ Lookup, 
                /*uint*/int NewAbbrev) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::writeRecordWithAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 138,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 137,
   FQN="(anonymous namespace)::SDiagsMerger::writeRecordWithAbbrev", NM="_ZN12_GLOBAL__N_112SDiagsMerger21writeRecordWithAbbrevEjRN4llvm11SmallVectorIyLj64EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger21writeRecordWithAbbrevEjRN4llvm11SmallVectorIyLj64EEE")
  //</editor-fold>
  private void writeRecordWithAbbrev(/*uint*/int ID, SmallVectorULong /*&*/ Record) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::writeRecordWithBlob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 140,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 139,
   FQN="(anonymous namespace)::SDiagsMerger::writeRecordWithBlob", NM="_ZN12_GLOBAL__N_112SDiagsMerger19writeRecordWithBlobEjRN4llvm11SmallVectorIyLj64EEENS1_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMerger19writeRecordWithBlobEjRN4llvm11SmallVectorIyLj64EEENS1_9StringRefE")
  //</editor-fold>
  private void writeRecordWithBlob(/*uint*/int ID, SmallVectorULong /*&*/ Record, StringRef Blob) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsMerger::~SDiagsMerger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 99,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 98,
   FQN="(anonymous namespace)::SDiagsMerger::~SDiagsMerger", NM="_ZN12_GLOBAL__N_112SDiagsMergerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsMergerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DiagFlagLookup.$destroy();
    CategoryLookup.$destroy();
    FileLookup.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Writer=" + Writer // NOI18N
              + ", FileLookup=" + FileLookup // NOI18N
              + ", CategoryLookup=" + CategoryLookup // NOI18N
              + ", DiagFlagLookup=" + DiagFlagLookup // NOI18N
              + super.toString(); // NOI18N
  }
}
