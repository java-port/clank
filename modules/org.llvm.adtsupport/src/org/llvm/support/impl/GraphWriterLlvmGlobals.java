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
package org.llvm.support.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type GraphWriterLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=Tpl__ZN4llvm10WriteGraphERKT_RKNS_5TwineEbS5_;Tpl__ZN4llvm10WriteGraphERNS_11raw_ostreamERKT_bRKNS_5TwineE;Tpl__ZN4llvm9ViewGraphERKT_RKNS_5TwineEbS5_NS_12GraphProgram4NameE;_ZN4llvm12DisplayGraphENS_9StringRefEbNS_12GraphProgram4NameE;_ZN4llvm19createGraphFilenameERKNS_5TwineERi; -static-type=GraphWriterLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class GraphWriterLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::DisplayGraph">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp", line = 135,
 FQN="llvm::DisplayGraph", NM="_ZN4llvm12DisplayGraphENS_9StringRefEbNS_12GraphProgram4NameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm12DisplayGraphENS_9StringRefEbNS_12GraphProgram4NameE")
//</editor-fold>
public static boolean DisplayGraph(StringRef FilenameRef) {
  return DisplayGraph(FilenameRef, true, 
            GraphProgram.Name.DOT);
}
public static boolean DisplayGraph(StringRef FilenameRef, boolean wait/*= true*/) {
  return DisplayGraph(FilenameRef, wait, 
            GraphProgram.Name.DOT);
}
public static boolean DisplayGraph(StringRef FilenameRef, boolean wait/*= true*/, 
            GraphProgram.Name program/*= GraphProgram::DOT*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename GraphType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::WriteGraph">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 311,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", old_line = 310,
 FQN="llvm::WriteGraph", NM="Tpl__ZN4llvm10WriteGraphERNS_11raw_ostreamERKT_bRKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=Tpl__ZN4llvm10WriteGraphERNS_11raw_ostreamERKT_bRKNS_5TwineE")
//</editor-fold>
public static </*typename*/ GraphType> raw_ostream /*&*/ WriteGraph(final raw_ostream /*&*/ O, final /*const*/ GraphType /*&*/ G) {
  return WriteGraph(O, G, 
          false, 
          new Twine(/*KEEP_STR*/$EMPTY));
}
public static </*typename*/ GraphType> raw_ostream /*&*/ WriteGraph(final raw_ostream /*&*/ O, final /*const*/ GraphType /*&*/ G, 
          boolean ShortNames/*= false*/) {
  return WriteGraph(O, G, 
          ShortNames, 
          new Twine(/*KEEP_STR*/$EMPTY));
}
public static </*typename*/ GraphType> raw_ostream /*&*/ WriteGraph(final raw_ostream /*&*/ O, final /*const*/ GraphType /*&*/ G, 
          boolean ShortNames/*= false*/, 
          final /*const*/ Twine /*&*/ Title/*= ""*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createGraphFilename">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp", line = 67,
 FQN="llvm::createGraphFilename", NM="_ZN4llvm19createGraphFilenameERKNS_5TwineERi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm19createGraphFilenameERKNS_5TwineERi")
//</editor-fold>
public static std.string createGraphFilename(final /*const*/ Twine /*&*/ Name, final int$ref/*int &*/ FD) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename GraphType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::WriteGraph">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 326,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", old_line = 325,
 FQN="llvm::WriteGraph", NM="Tpl__ZN4llvm10WriteGraphERKT_RKNS_5TwineEbS5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=Tpl__ZN4llvm10WriteGraphERKT_RKNS_5TwineEbS5_")
//</editor-fold>
public static </*typename*/ GraphType> std.string WriteGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name) {
  return WriteGraph(G, Name, 
          false, new Twine(/*KEEP_STR*/$EMPTY));
}
public static </*typename*/ GraphType> std.string WriteGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name, 
          boolean ShortNames/*= false*/) {
  return WriteGraph(G, Name, 
          ShortNames, new Twine(/*KEEP_STR*/$EMPTY));
}
public static </*typename*/ GraphType> std.string WriteGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name, 
          boolean ShortNames/*= false*/, final /*const*/ Twine /*&*/ Title/*= ""*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// ViewGraph - Emit a dot graph, run 'dot', run gv on the postscript file,
/// then cleanup.  For use from the debugger.
///
/*template <typename GraphType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ViewGraph">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 350,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", old_line = 349,
 FQN="llvm::ViewGraph", NM="Tpl__ZN4llvm9ViewGraphERKT_RKNS_5TwineEbS5_NS_12GraphProgram4NameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=Tpl__ZN4llvm9ViewGraphERKT_RKNS_5TwineEbS5_NS_12GraphProgram4NameE")
//</editor-fold>
public static </*typename*/ GraphType> void ViewGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name) {
  ViewGraph(G, Name, 
         false, new Twine(/*KEEP_STR*/$EMPTY), 
         GraphProgram.Name.DOT);
}
public static </*typename*/ GraphType> void ViewGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name, 
         boolean ShortNames/*= false*/) {
  ViewGraph(G, Name, 
         ShortNames, new Twine(/*KEEP_STR*/$EMPTY), 
         GraphProgram.Name.DOT);
}
public static </*typename*/ GraphType> void ViewGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name, 
         boolean ShortNames/*= false*/, final /*const*/ Twine /*&*/ Title/*= ""*/) {
  ViewGraph(G, Name, 
         ShortNames, Title, 
         GraphProgram.Name.DOT);
}
public static </*typename*/ GraphType> void ViewGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name, 
         boolean ShortNames/*= false*/, final /*const*/ Twine /*&*/ Title/*= ""*/, 
         GraphProgram.Name Program/*= GraphProgram::DOT*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class GraphWriterLlvmGlobals
