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


/// \brief Record types used within a submodule description block.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::SubmoduleRecordTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 647,
 FQN="clang::serialization::SubmoduleRecordTypes", NM="_ZN5clang13serialization20SubmoduleRecordTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization20SubmoduleRecordTypesE")
//</editor-fold>
public final class/*enum*/ SubmoduleRecordTypes {
  /// \brief Metadata for submodules as a whole.
  public static final int SUBMODULE_METADATA = 0;
  /// \brief Defines the major attributes of a submodule, including its
  /// name and parent.
  public static final int SUBMODULE_DEFINITION = 1;
  /// \brief Specifies the umbrella header used to create this module,
  /// if any.
  public static final int SUBMODULE_UMBRELLA_HEADER = 2;
  /// \brief Specifies a header that falls into this (sub)module.
  public static final int SUBMODULE_HEADER = 3;
  /// \brief Specifies a top-level header that falls into this (sub)module.
  public static final int SUBMODULE_TOPHEADER = 4;
  /// \brief Specifies an umbrella directory.
  public static final int SUBMODULE_UMBRELLA_DIR = 5;
  /// \brief Specifies the submodules that are imported by this 
  /// submodule.
  public static final int SUBMODULE_IMPORTS = 6;
  /// \brief Specifies the submodules that are re-exported from this 
  /// submodule.
  public static final int SUBMODULE_EXPORTS = 7;
  /// \brief Specifies a required feature.
  public static final int SUBMODULE_REQUIRES = 8;
  /// \brief Specifies a header that has been explicitly excluded
  /// from this submodule.
  public static final int SUBMODULE_EXCLUDED_HEADER = 9;
  /// \brief Specifies a library or framework to link against.
  public static final int SUBMODULE_LINK_LIBRARY = 10;
  /// \brief Specifies a configuration macro for this module.
  public static final int SUBMODULE_CONFIG_MACRO = 11;
  /// \brief Specifies a conflict with another module.
  public static final int SUBMODULE_CONFLICT = 12;
  /// \brief Specifies a header that is private to this submodule.
  public static final int SUBMODULE_PRIVATE_HEADER = 13;
  /// \brief Specifies a header that is part of the module but must be
  /// textually included.
  public static final int SUBMODULE_TEXTUAL_HEADER = 14;
  /// \brief Specifies a header that is private to this submodule but
  /// must be textually included.
  public static final int SUBMODULE_PRIVATE_TEXTUAL_HEADER = 15;
}
