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


/// \brief Record types that occur within the AST block itself.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::ASTRecordTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 342,
 FQN="clang::serialization::ASTRecordTypes", NM="_ZN5clang13serialization14ASTRecordTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization14ASTRecordTypesE")
//</editor-fold>
public final class/*enum*/ ASTRecordTypes {
  /// \brief Record code for the offsets of each type.
  ///
  /// The TYPE_OFFSET constant describes the record that occurs
  /// within the AST block. The record itself is an array of offsets that
  /// point into the declarations and types block (identified by 
  /// DECLTYPES_BLOCK_ID). The index into the array is based on the ID
  /// of a type. For a given type ID @c T, the lower three bits of
  /// @c T are its qualifiers (const, volatile, restrict), as in
  /// the QualType class. The upper bits, after being shifted and
  /// subtracting NUM_PREDEF_TYPE_IDS, are used to index into the
  /// TYPE_OFFSET block to determine the offset of that type's
  /// corresponding record within the DECLTYPES_BLOCK_ID block.
  public static final int TYPE_OFFSET = 1;
  
  /// \brief Record code for the offsets of each decl.
  ///
  /// The DECL_OFFSET constant describes the record that occurs
  /// within the block identified by DECL_OFFSETS_BLOCK_ID within
  /// the AST block. The record itself is an array of offsets that
  /// point into the declarations and types block (identified by
  /// DECLTYPES_BLOCK_ID). The declaration ID is an index into this
  /// record, after subtracting one to account for the use of
  /// declaration ID 0 for a NULL declaration pointer. Index 0 is
  /// reserved for the translation unit declaration.
  public static final int DECL_OFFSET = 2;
  
  /// \brief Record code for the table of offsets of each
  /// identifier ID.
  ///
  /// The offset table contains offsets into the blob stored in
  /// the IDENTIFIER_TABLE record. Each offset points to the
  /// NULL-terminated string that corresponds to that identifier.
  public static final int IDENTIFIER_OFFSET = 3;
  
  /// \brief This is so that older clang versions, before the introduction
  /// of the control block, can read and reject the newer PCH format.
  /// *DON'T CHANGE THIS NUMBER*.
  public static final int METADATA_OLD_FORMAT = 4;
  
  /// \brief Record code for the identifier table.
  ///
  /// The identifier table is a simple blob that contains
  /// NULL-terminated strings for all of the identifiers
  /// referenced by the AST file. The IDENTIFIER_OFFSET table
  /// contains the mapping from identifier IDs to the characters
  /// in this blob. Note that the starting offsets of all of the
  /// identifiers are odd, so that, when the identifier offset
  /// table is loaded in, we can use the low bit to distinguish
  /// between offsets (for unresolved identifier IDs) and
  /// IdentifierInfo pointers (for already-resolved identifier
  /// IDs).
  public static final int IDENTIFIER_TABLE = 5;
  
  /// \brief Record code for the array of eagerly deserialized decls.
  ///
  /// The AST file contains a list of all of the declarations that should be
  /// eagerly deserialized present within the parsed headers, stored as an
  /// array of declaration IDs. These declarations will be
  /// reported to the AST consumer after the AST file has been
  /// read, since their presence can affect the semantics of the
  /// program (e.g., for code generation).
  public static final int EAGERLY_DESERIALIZED_DECLS = 6;
  
  /// \brief Record code for the set of non-builtin, special
  /// types.
  ///
  /// This record contains the type IDs for the various type nodes
  /// that are constructed during semantic analysis (e.g.,
  /// __builtin_va_list). The SPECIAL_TYPE_* constants provide
  /// offsets into this record.
  public static final int SPECIAL_TYPES = 7;
  
  /// \brief Record code for the extra statistics we gather while
  /// generating an AST file.
  public static final int STATISTICS = 8;
  
  /// \brief Record code for the array of tentative definitions.
  public static final int TENTATIVE_DEFINITIONS = 9;
  
  // ID 10 used to be for a list of extern "C" declarations.
  
  /// \brief Record code for the table of offsets into the
  /// Objective-C method pool.
  public static final int SELECTOR_OFFSETS = 11;
  
  /// \brief Record code for the Objective-C method pool,
  public static final int METHOD_POOL = 12;
  
  /// \brief The value of the next __COUNTER__ to dispense.
  /// [PP_COUNTER_VALUE, Val]
  public static final int PP_COUNTER_VALUE = 13;
  
  /// \brief Record code for the table of offsets into the block
  /// of source-location information.
  public static final int SOURCE_LOCATION_OFFSETS = 14;
  
  /// \brief Record code for the set of source location entries
  /// that need to be preloaded by the AST reader.
  ///
  /// This set contains the source location entry for the
  /// predefines buffer and for any file entries that need to be
  /// preloaded.
  public static final int SOURCE_LOCATION_PRELOADS = 15;
  
  /// \brief Record code for the set of ext_vector type names.
  public static final int EXT_VECTOR_DECLS = 16;
  
  /// \brief Record code for the array of unused file scoped decls.
  public static final int UNUSED_FILESCOPED_DECLS = 17;
  
  /// \brief Record code for the table of offsets to entries in the
  /// preprocessing record.
  public static final int PPD_ENTITIES_OFFSETS = 18;
  
  /// \brief Record code for the array of VTable uses.
  public static final int VTABLE_USES = 19;
  
  // ID 20 used to be for a list of dynamic classes.
  
  /// \brief Record code for referenced selector pool.
  public static final int REFERENCED_SELECTOR_POOL = 21;
  
  /// \brief Record code for an update to the TU's lexically contained
  /// declarations.
  public static final int TU_UPDATE_LEXICAL = 22;
  
  // ID 23 used to be for a list of local redeclarations.
  
  /// \brief Record code for declarations that Sema keeps references of.
  public static final int SEMA_DECL_REFS = 24;
  
  /// \brief Record code for weak undeclared identifiers.
  public static final int WEAK_UNDECLARED_IDENTIFIERS = 25;
  
  /// \brief Record code for pending implicit instantiations.
  public static final int PENDING_IMPLICIT_INSTANTIATIONS = 26;
  
  // ID 27 used to be for a list of replacement decls.
  
  /// \brief Record code for an update to a decl context's lookup table.
  ///
  /// In practice, this should only be used for the TU and namespaces.
  public static final int UPDATE_VISIBLE = 28;
  
  /// \brief Record for offsets of DECL_UPDATES records for declarations
  /// that were modified after being deserialized and need updates.
  public static final int DECL_UPDATE_OFFSETS = 29;
  
  // ID 30 used to be a decl update record. These are now in the DECLTYPES
  // block.
  
  // ID 31 used to be a list of offsets to DECL_CXX_BASE_SPECIFIERS records.
  
  /// \brief Record code for \#pragma diagnostic mappings.
  public static final int DIAG_PRAGMA_MAPPINGS = 32;
  
  /// \brief Record code for special CUDA declarations.
  public static final int CUDA_SPECIAL_DECL_REFS = 33;
  
  /// \brief Record code for header search information.
  public static final int HEADER_SEARCH_TABLE = 34;
  
  /// \brief Record code for floating point \#pragma options.
  public static final int FP_PRAGMA_OPTIONS = 35;
  
  /// \brief Record code for enabled OpenCL extensions.
  public static final int OPENCL_EXTENSIONS = 36;
  
  /// \brief The list of delegating constructor declarations.
  public static final int DELEGATING_CTORS = 37;
  
  /// \brief Record code for the set of known namespaces, which are used
  /// for typo correction.
  public static final int KNOWN_NAMESPACES = 38;
  
  /// \brief Record code for the remapping information used to relate
  /// loaded modules to the various offsets and IDs(e.g., source location 
  /// offests, declaration and type IDs) that are used in that module to
  /// refer to other modules.
  public static final int MODULE_OFFSET_MAP = 39;
  
  /// \brief Record code for the source manager line table information,
  /// which stores information about \#line directives.
  public static final int SOURCE_MANAGER_LINE_TABLE = 40;
  
  /// \brief Record code for map of Objective-C class definition IDs to the 
  /// ObjC categories in a module that are attached to that class.
  public static final int OBJC_CATEGORIES_MAP = 41;
  
  /// \brief Record code for a file sorted array of DeclIDs in a module.
  public static final int FILE_SORTED_DECLS = 42;
  
  /// \brief Record code for an array of all of the (sub)modules that were
  /// imported by the AST file.
  public static final int IMPORTED_MODULES = 43;
  
  // ID 44 used to be a table of merged canonical declarations.
  // ID 45 used to be a list of declaration IDs of local redeclarations.
  
  /// \brief Record code for the array of Objective-C categories (including
  /// extensions).
  ///
  /// This array can only be interpreted properly using the Objective-C
  /// categories map.
  public static final int OBJC_CATEGORIES = 46;
  
  /// \brief Record code for the table of offsets of each macro ID.
  ///
  /// The offset table contains offsets into the blob stored in
  /// the preprocessor block. Each offset points to the corresponding
  /// macro definition.
  public static final int MACRO_OFFSET = 47;
  
  /// \brief A list of "interesting" identifiers. Only used in C++ (where we
  /// don't normally do lookups into the serialized identifier table). These
  /// are eagerly deserialized.
  public static final int INTERESTING_IDENTIFIERS = 48;
  
  /// \brief Record code for undefined but used functions and variables that
  /// need a definition in this TU.
  public static final int UNDEFINED_BUT_USED = 49;
  
  /// \brief Record code for late parsed template functions.
  public static final int LATE_PARSED_TEMPLATE = 50;
  
  /// \brief Record code for \#pragma optimize options.
  public static final int OPTIMIZE_PRAGMA_OPTIONS = 51;
  
  /// \brief Record code for potentially unused local typedef names.
  public static final int UNUSED_LOCAL_TYPEDEF_NAME_CANDIDATES = 52;
  
  // ID 53 used to be a table of constructor initializer records.
  
  /// \brief Delete expressions that will be analyzed later.
  public static final int DELETE_EXPRS_TO_ANALYZE = 54;
  
  /// \brief Record code for \#pragma ms_struct options.
  public static final int MSSTRUCT_PRAGMA_OPTIONS = 55;
  
  /// \brief Record code for \#pragma ms_struct options.
  public static final int POINTERS_TO_MEMBERS_PRAGMA_OPTIONS = 56;
}
