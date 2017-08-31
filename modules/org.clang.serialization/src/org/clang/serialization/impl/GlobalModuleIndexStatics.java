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
package org.clang.serialization.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.bitcode.*;
import org.llvm.bitcode.bitc.*;
import org.llvm.adt.aliases.*;


//<editor-fold defaultstate="collapsed" desc="static type GlobalModuleIndexStatics">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 NM="org.clang.serialization.impl.GlobalModuleIndexStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_GlobalModuleIndex_cpp_Unnamed_enum;_ZL11emitBlockIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE;_ZL12emitRecordIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE;_ZL13IndexFileName;_ZL14CurrentVersion; -static-type=GlobalModuleIndexStatics -package=org.clang.serialization.impl")
//</editor-fold>
public final class GlobalModuleIndexStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 40,
 FQN="(anonymous namespace)::(anonymous)", NM="_GlobalModuleIndex_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_GlobalModuleIndex_cpp_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  /// \brief The block containing the index.
  public static final /*uint*/int GLOBAL_INDEX_BLOCK_ID = StandardBlockIDs.FIRST_APPLICATION_BLOCKID;
/*}*/

/// \brief The name of the global index file.
//<editor-fold defaultstate="collapsed" desc="IndexFileName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 58,
 FQN="IndexFileName", NM="_ZL13IndexFileName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZL13IndexFileName")
//</editor-fold>
public static /*const*/char$ptr/*char P*//*const*/ IndexFileName = $("modules.idx");

/// \brief The global index file version.
//<editor-fold defaultstate="collapsed" desc="CurrentVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 61,
 FQN="CurrentVersion", NM="_ZL14CurrentVersion",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZL14CurrentVersion")
//</editor-fold>
public static /*const*//*uint*/int CurrentVersion = 1;
//<editor-fold defaultstate="collapsed" desc="emitBlockID">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 435,
 FQN="emitBlockID", NM="_ZL11emitBlockIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZL11emitBlockIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE")
//</editor-fold>
public static void emitBlockID(/*uint*/int ID, /*const*/char$ptr/*char P*/ Name, 
           final BitstreamWriter /*&*/ Stream, 
           final SmallVectorImplULong /*&*/ Record) {
  Record.clear();
  Record.push_back($uint2ullong(ID));
  Stream.EmitRecord(BlockInfoCodes.BLOCKINFO_CODE_SETBID.getValue(), Record);
  
  // Emit the block name if present.
  if (!Native.$bool(Name) || Name.$at(0) == 0) {
    return;
  }
  Record.clear();
  // JAVA: don't modify input pointer
  int Name$Idx = 0;
  while ((Name.$at(Name$Idx) != 0)) {
    Record.push_back($char2ullong(Name.$at(Name$Idx++)));
  }
  Stream.EmitRecord(BlockInfoCodes.BLOCKINFO_CODE_BLOCKNAME.getValue(), Record);
}

//<editor-fold defaultstate="collapsed" desc="emitRecordID">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 450,
 FQN="emitRecordID", NM="_ZL12emitRecordIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZL12emitRecordIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE")
//</editor-fold>
public static void emitRecordID(/*uint*/int ID, /*const*/char$ptr/*char P*/ Name, 
            final BitstreamWriter /*&*/ Stream, 
            final SmallVectorImplULong /*&*/ Record) {
  Record.clear();
  Record.push_back($uint2ullong(ID));
  // JAVA: don't modify input pointer
  int Name$Idx = 0;  
  while ((Name.$at(Name$Idx) != 0)) {
    Record.push_back($char2ullong(Name.$at(Name$Idx++)));
  }
  Stream.EmitRecord(BlockInfoCodes.BLOCKINFO_CODE_SETRECORDNAME.getValue(), Record);
}

} // END OF class GlobalModuleIndexStatics
