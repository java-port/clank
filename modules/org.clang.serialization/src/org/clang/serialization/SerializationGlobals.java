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


//<editor-fold defaultstate="collapsed" desc="static type SerializationGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.serialization.SerializationGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL12DECL_UPDATESE;_ZN5clang13serializationL13VERSION_MAJORE;_ZN5clang13serializationL13VERSION_MINORE;_ZN5clang13serializationL17NumSpecialTypeIDsE;_ZN5clang13serializationL19NUM_PREDEF_DECL_IDSE;_ZN5clang13serializationL19NUM_PREDEF_TYPE_IDSE;_ZN5clang13serializationL20LOCAL_REDECLARATIONSE;_ZN5clang13serializationL20NUM_PREDEF_IDENT_IDSE;_ZN5clang13serializationL20NUM_PREDEF_MACRO_IDSE;_ZN5clang13serializationL23NUM_PREDEF_SELECTOR_IDSE;_ZN5clang13serializationL24NUM_PREDEF_PP_ENTITY_IDSE;_ZN5clang13serializationL24NUM_PREDEF_SUBMODULE_IDSE; -static-type=SerializationGlobals -package=org.clang.serialization")
//</editor-fold>
public final class SerializationGlobals {

/// \brief AST file major version number supported by this version of
/// Clang.
///
/// Whenever the AST file format changes in a way that makes it
/// incompatible with previous versions (such that a reader
/// designed for the previous version could not support reading
/// the new version), this number should be increased.
///
/// Version 4 of AST files also requires that the version control branch and
/// revision match exactly, since there is no backward compatibility of
/// AST files at this time.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::VERSION_MAJOR">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 39,
 FQN="clang::serialization::VERSION_MAJOR", NM="_ZN5clang13serializationL13VERSION_MAJORE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL13VERSION_MAJORE")
//</editor-fold>
public static /*const*//*uint*/int VERSION_MAJOR = 6;

/// \brief AST file minor version number supported by this version of
/// Clang.
///
/// Whenever the AST format changes in a way that is still
/// compatible with previous versions (such that a reader designed
/// for the previous version could still support reading the new
/// version by ignoring new kinds of subblocks), this number
/// should be increased.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::VERSION_MINOR">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 49,
 FQN="clang::serialization::VERSION_MINOR", NM="_ZN5clang13serializationL13VERSION_MINORE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL13VERSION_MINORE")
//</editor-fold>
public static /*const*//*uint*/int VERSION_MINOR = 0;

/// \brief The number of predefined identifier IDs.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::NUM_PREDEF_IDENT_IDS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 126,
 FQN="clang::serialization::NUM_PREDEF_IDENT_IDS", NM="_ZN5clang13serializationL20NUM_PREDEF_IDENT_IDSE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL20NUM_PREDEF_IDENT_IDSE")
//</editor-fold>
public static /*const*//*uint*/int NUM_PREDEF_IDENT_IDS = 1;

/// \brief The number of predefined macro IDs.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::NUM_PREDEF_MACRO_IDS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 139,
 FQN="clang::serialization::NUM_PREDEF_MACRO_IDS", NM="_ZN5clang13serializationL20NUM_PREDEF_MACRO_IDSE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL20NUM_PREDEF_MACRO_IDSE")
//</editor-fold>
public static /*const*//*uint*/int NUM_PREDEF_MACRO_IDS = 1;

/// \brief The number of predefined selector IDs.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::NUM_PREDEF_SELECTOR_IDS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 145,
 FQN="clang::serialization::NUM_PREDEF_SELECTOR_IDS", NM="_ZN5clang13serializationL23NUM_PREDEF_SELECTOR_IDSE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL23NUM_PREDEF_SELECTOR_IDSE")
//</editor-fold>
public static /*const*//*uint*/int NUM_PREDEF_SELECTOR_IDS = 1;

/// \brief The number of predefined submodule IDs.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::NUM_PREDEF_SUBMODULE_IDS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 163,
 FQN="clang::serialization::NUM_PREDEF_SUBMODULE_IDS", NM="_ZN5clang13serializationL24NUM_PREDEF_SUBMODULE_IDSE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL24NUM_PREDEF_SUBMODULE_IDSE")
//</editor-fold>
public static /*const*//*uint*/int NUM_PREDEF_SUBMODULE_IDS = 1;

/// \brief The number of predefined preprocessed entity IDs.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::NUM_PREDEF_PP_ENTITY_IDS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 206,
 FQN="clang::serialization::NUM_PREDEF_PP_ENTITY_IDS", NM="_ZN5clang13serializationL24NUM_PREDEF_PP_ENTITY_IDSE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL24NUM_PREDEF_PP_ENTITY_IDSE")
//</editor-fold>
public static /*const*//*uint*/int NUM_PREDEF_PP_ENTITY_IDS = 1;

/// \brief The number of predefined type IDs that are reserved for
/// the PREDEF_TYPE_* constants.
///
/// Type IDs for non-predefined types will start at
/// NUM_PREDEF_TYPE_IDs.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::NUM_PREDEF_TYPE_IDS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 810,
 FQN="clang::serialization::NUM_PREDEF_TYPE_IDS", NM="_ZN5clang13serializationL19NUM_PREDEF_TYPE_IDSE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL19NUM_PREDEF_TYPE_IDSE")
//</editor-fold>
public static /*const*//*uint*/int NUM_PREDEF_TYPE_IDS = 100;

/// \brief The number of special type IDs.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::NumSpecialTypeIDs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 930,
 FQN="clang::serialization::NumSpecialTypeIDs", NM="_ZN5clang13serializationL17NumSpecialTypeIDsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL17NumSpecialTypeIDsE")
//</editor-fold>
public static /*const*//*uint*/int NumSpecialTypeIDs = 8;

/// \brief The number of declaration IDs that are predefined.
///
/// For more information about predefined declarations, see the
/// \c PredefinedDeclIDs type and the PREDEF_DECL_*_ID constants.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::NUM_PREDEF_DECL_IDS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 995,
 FQN="clang::serialization::NUM_PREDEF_DECL_IDS", NM="_ZN5clang13serializationL19NUM_PREDEF_DECL_IDSE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL19NUM_PREDEF_DECL_IDSE")
//</editor-fold>
public static /*const*//*uint*/int NUM_PREDEF_DECL_IDS = 17;

/// \brief Record of updates for a declaration that was modified after
/// being deserialized. This can occur within DECLTYPES_BLOCK_ID.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::DECL_UPDATES">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 999,
 FQN="clang::serialization::DECL_UPDATES", NM="_ZN5clang13serializationL12DECL_UPDATESE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL12DECL_UPDATESE")
//</editor-fold>
public static /*const*//*uint*/int DECL_UPDATES = 49;

/// \brief Record code for a list of local redeclarations of a declaration.
/// This can occur within DECLTYPES_BLOCK_ID.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::LOCAL_REDECLARATIONS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1003,
 FQN="clang::serialization::LOCAL_REDECLARATIONS", NM="_ZN5clang13serializationL20LOCAL_REDECLARATIONSE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationL20LOCAL_REDECLARATIONSE")
//</editor-fold>
public static /*const*//*uint*/int LOCAL_REDECLARATIONS = 50;
} // END OF class SerializationGlobals
