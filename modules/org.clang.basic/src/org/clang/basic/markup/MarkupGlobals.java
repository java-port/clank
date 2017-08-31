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
package org.clang.basic.markup;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type MarkupGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/PlistReporter.cpp -nm=_ZN5clang6markup10EmitStringERN4llvm11raw_ostreamENS1_9StringRefE;_ZN5clang6markup11EmitIntegerERN4llvm11raw_ostreamEx;_ZN5clang6markup12EmitLocationERN4llvm11raw_ostreamERKNS_13SourceManagerENS_14SourceLocationERKNS1_8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS9_EENS1_6detail12DenseMapPairIS9_jEEEEj;_ZN5clang6markup15EmitPlistHeaderERN4llvm11raw_ostreamE;_ZN5clang6markup6AddFIDERN4llvm8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS3_EENS1_6detail12DenseMapPairIS3_jEEEERNS1_15SmallVectorImplIS3_EERKNS_13SourceManagerENS_14SourceLocationE;_ZN5clang6markup6GetFIDERKN4llvm8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS3_EENS1_6detail12DenseMapPairIS3_jEEEERKNS_13SourceManagerENS_14SourceLocationE;_ZN5clang6markup6IndentERN4llvm11raw_ostreamEj;_ZN5clang6markup9EmitRangeERN4llvm11raw_ostreamERKNS_13SourceManagerENS_15CharSourceRangeERKNS1_8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS9_EENS1_6detail12DenseMapPairIS9_jEEEEj; -static-type=MarkupGlobals -package=org.clang.basic.markup")
//</editor-fold>
public final class MarkupGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::markup::AddFID">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", line = 21,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", old_line = 22,
 FQN="clang::markup::AddFID", NM="_ZN5clang6markup6AddFIDERN4llvm8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS3_EENS1_6detail12DenseMapPairIS3_jEEEERNS1_15SmallVectorImplIS3_EERKNS_13SourceManagerENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/PlistReporter.cpp -nm=_ZN5clang6markup6AddFIDERN4llvm8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS3_EENS1_6detail12DenseMapPairIS3_jEEEERNS1_15SmallVectorImplIS3_EERKNS_13SourceManagerENS_14SourceLocationE")
//</editor-fold>
public static /*inline*/ void AddFID(DenseMapTypeUInt<FileID>/*&*/ FIDs, SmallVectorImpl<FileID> /*&*/ V, 
      /*const*/ SourceManager /*&*/ SM, SourceLocation L) {
  FileID FID = SM.getFileID(SM.getExpansionLoc(/*NO_COPY*/L));
  DenseMapIteratorTypeUInt<FileID> I = FIDs.find(FID);
  if (I.$noteq(FIDs.end())) {
    return;
  }
  FIDs.$set(FID, V.size());
  V.push_back(FID);
}

//<editor-fold defaultstate="collapsed" desc="clang::markup::GetFID">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", line = 31,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", old_line = 32,
 FQN="clang::markup::GetFID", NM="_ZN5clang6markup6GetFIDERKN4llvm8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS3_EENS1_6detail12DenseMapPairIS3_jEEEERKNS_13SourceManagerENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/PlistReporter.cpp -nm=_ZN5clang6markup6GetFIDERKN4llvm8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS3_EENS1_6detail12DenseMapPairIS3_jEEEERKNS_13SourceManagerENS_14SourceLocationE")
//</editor-fold>
public static /*inline*/ /*uint*/int GetFID(/*const*/DenseMapTypeUInt<FileID>/*&*/ FIDs, /*const*/ SourceManager /*&*/ SM, 
      SourceLocation L) {
  FileID FID = SM.getFileID(SM.getExpansionLoc(/*NO_COPY*/L));
  DenseMapIteratorTypeUInt<FileID> I = FIDs.find(FID);
  assert (I.$noteq(FIDs.end()));
  return I.$star().second;
}

//<editor-fold defaultstate="collapsed" desc="clang::markup::Indent">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", line = 39,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", old_line = 40,
 FQN="clang::markup::Indent", NM="_ZN5clang6markup6IndentERN4llvm11raw_ostreamEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/PlistReporter.cpp -nm=_ZN5clang6markup6IndentERN4llvm11raw_ostreamEj")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ Indent(raw_ostream /*&*/ o, /*const*//*uint*/int indent) {
  for (/*uint*/int i = 0; $less_uint(i, indent); ++i)  {
    o.$out_char($$SPACE);
  }
  return o;
}

//<editor-fold defaultstate="collapsed" desc="clang::markup::EmitPlistHeader">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", line = 45,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", old_line = 46,
 FQN="clang::markup::EmitPlistHeader", NM="_ZN5clang6markup15EmitPlistHeaderERN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/PlistReporter.cpp -nm=_ZN5clang6markup15EmitPlistHeaderERN4llvm11raw_ostreamE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ EmitPlistHeader(raw_ostream /*&*/ o) {
  final/*static*/ /*const*/char$ptr/*char P*/ PlistHeader = EmitPlistHeader$$.PlistHeader;
  return o.$out(PlistHeader);
}
public static final class EmitPlistHeader$$ {
  static final/*static*/ /*const*/char$ptr/*char P*/ PlistHeader = $("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE plist PUBLIC \"-//Apple Computer//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n<plist version=\"1.0\">\n");
}

//<editor-fold defaultstate="collapsed" desc="clang::markup::EmitInteger">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", line = 54,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", old_line = 55,
 FQN="clang::markup::EmitInteger", NM="_ZN5clang6markup11EmitIntegerERN4llvm11raw_ostreamEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/PlistReporter.cpp -nm=_ZN5clang6markup11EmitIntegerERN4llvm11raw_ostreamEx")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ EmitInteger(raw_ostream /*&*/ o, long/*int64_t*/ value) {
  o.$out(/*KEEP_STR*/"<integer>");
  o.$out_llong(value);
  o.$out(/*KEEP_STR*/"</integer>");
  return o;
}

//<editor-fold defaultstate="collapsed" desc="clang::markup::EmitString">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", line = 61,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", old_line = 62,
 FQN="clang::markup::EmitString", NM="_ZN5clang6markup10EmitStringERN4llvm11raw_ostreamENS1_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/PlistReporter.cpp -nm=_ZN5clang6markup10EmitStringERN4llvm11raw_ostreamENS1_9StringRefE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ EmitString(raw_ostream /*&*/ o, StringRef s) {
  o.$out(/*KEEP_STR*/"<string>");
  for (char$ptr I = $tryClone(s.begin()), /*P*/ E = $tryClone(s.end()); $noteq_ptr(I, E); I.$preInc()) {
    /*char*/byte c = I.$star();
    switch (c) {
     default:
      o.$out_char(c);
      break;
     case '&':
      o.$out(/*KEEP_STR*/"&amp;");
      break;
     case '<':
      o.$out(/*KEEP_STR*/"&lt;");
      break;
     case '>':
      o.$out(/*KEEP_STR*/"&gt;");
      break;
     case '\'':
      o.$out(/*KEEP_STR*/"&apos;");
      break;
     case '"':
      o.$out(/*KEEP_STR*/"&quot;");
      break;
    }
  }
  o.$out(/*KEEP_STR*/"</string>");
  return o;
}

//<editor-fold defaultstate="collapsed" desc="clang::markup::EmitLocation">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", line = 90,
 FQN="clang::markup::EmitLocation", NM="_ZN5clang6markup12EmitLocationERN4llvm11raw_ostreamERKNS_13SourceManagerENS_14SourceLocationERKNS1_8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS9_EENS1_6detail12DenseMapPairIS9_jEEEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/PlistReporter.cpp -nm=_ZN5clang6markup12EmitLocationERN4llvm11raw_ostreamERKNS_13SourceManagerENS_14SourceLocationERKNS1_8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS9_EENS1_6detail12DenseMapPairIS9_jEEEEj")
//</editor-fold>
public static /*inline*/ void EmitLocation(raw_ostream /*&*/ o, /*const*/ SourceManager /*&*/ SM, 
            SourceLocation L, /*const*/DenseMapTypeUInt<FileID>/*&*/ FM, /*uint*/int indent) {
  if (L.isInvalid()) {
    return;
  }
  
  FullSourceLoc Loc/*J*/= new FullSourceLoc(SM.getExpansionLoc(/*NO_COPY*/L), ((/*const_cast*/SourceManager /*&*/ )(SM)));
  
  Indent(o, indent).$out(/*KEEP_STR*/"<dict>\n");
  Indent(o, indent).$out(/*KEEP_STR*/" <key>line</key>");
  EmitInteger(o, $uint2long(Loc.getExpansionLineNumber())).$out_char($$LF);
  Indent(o, indent).$out(/*KEEP_STR*/" <key>col</key>");
  EmitInteger(o, $uint2long(Loc.getExpansionColumnNumber())).$out_char($$LF);
  Indent(o, indent).$out(/*KEEP_STR*/" <key>file</key>");
  EmitInteger(o, $uint2long(GetFID(FM, SM, new SourceLocation(Loc)))).$out_char($$LF);
  Indent(o, indent).$out(/*KEEP_STR*/"</dict>\n");
}

//<editor-fold defaultstate="collapsed" desc="clang::markup::EmitRange">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PlistSupport.h", line = 106,
 FQN="clang::markup::EmitRange", NM="_ZN5clang6markup9EmitRangeERN4llvm11raw_ostreamERKNS_13SourceManagerENS_15CharSourceRangeERKNS1_8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS9_EENS1_6detail12DenseMapPairIS9_jEEEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/PlistReporter.cpp -nm=_ZN5clang6markup9EmitRangeERN4llvm11raw_ostreamERKNS_13SourceManagerENS_15CharSourceRangeERKNS1_8DenseMapINS_6FileIDEjNS1_12DenseMapInfoIS9_EENS1_6detail12DenseMapPairIS9_jEEEEj")
//</editor-fold>
public static /*inline*/ void EmitRange(raw_ostream /*&*/ o, /*const*/ SourceManager /*&*/ SM, 
         CharSourceRange R, /*const*/DenseMapTypeUInt<FileID>/*&*/ FM, /*uint*/int indent) {
  if (R.isInvalid()) {
    return;
  }
  assert (R.isCharRange()) : "cannot handle a token range";
  Indent(o, indent).$out(/*KEEP_STR*/"<array>\n");
  EmitLocation(o, SM, R.getBegin(), FM, indent + 1);
  EmitLocation(o, SM, R.getEnd(), FM, indent + 1);
  Indent(o, indent).$out(/*KEEP_STR*/"</array>\n");
}

} // END OF class MarkupGlobals
