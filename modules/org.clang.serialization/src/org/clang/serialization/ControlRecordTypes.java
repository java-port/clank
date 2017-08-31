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

package org.clang.serialization;

import org.clank.support.*;


/// \brief Record types that occur within the control block.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::ControlRecordTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 259,
 FQN="clang::serialization::ControlRecordTypes", NM="_ZN5clang13serialization18ControlRecordTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization18ControlRecordTypesE")
//</editor-fold>
public final class/*enum*/ ControlRecordTypes {
  /// \brief AST file metadata, including the AST file version number
  /// and information about the compiler used to build this AST file.
  public static final int METADATA = 1;
  
  /// \brief Record code for the list of other AST files imported by
  /// this AST file.
  public static final int IMPORTS = METADATA + 1;
  
  /// \brief Record code for the original file that was used to
  /// generate the AST file, including both its file ID and its
  /// name.
  public static final int ORIGINAL_FILE = IMPORTS + 1;
  
  /// \brief The directory that the PCH was originally created in.
  public static final int ORIGINAL_PCH_DIR = ORIGINAL_FILE + 1;
  
  /// \brief Record code for file ID of the file or buffer that was used to
  /// generate the AST file.
  public static final int ORIGINAL_FILE_ID = ORIGINAL_PCH_DIR + 1;
  
  /// \brief Offsets into the input-files block where input files
  /// reside.
  public static final int INPUT_FILE_OFFSETS = ORIGINAL_FILE_ID + 1;
  
  /// \brief Record code for the module name.
  public static final int MODULE_NAME = INPUT_FILE_OFFSETS + 1;
  
  /// \brief Record code for the module map file that was used to build this
  /// AST file.
  public static final int MODULE_MAP_FILE = MODULE_NAME + 1;
  
  /// \brief Record code for the signature that identifiers this AST file.
  public static final int SIGNATURE = MODULE_MAP_FILE + 1;
  
  /// \brief Record code for the module build directory.
  public static final int MODULE_DIRECTORY = SIGNATURE + 1;
}
