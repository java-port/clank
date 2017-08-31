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

package org.llvm.profiledata;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.Function;
import org.llvm.ir.Module;
import org.llvm.object.SectionRef;
import org.llvm.support.Error;


/// A symbol table used for function PGO name look-up with keys
/// (such as pointers, md5hash values) to the function. A function's
/// PGO name or name's md5hash are used in retrieving the profile
/// data of the function. See \c getPGOFuncName() method for details
/// on how PGO name is formed.
//<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 407,
 FQN="llvm::InstrProfSymtab", NM="_ZN4llvm15InstrProfSymtabE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtabE")
//</editor-fold>
public class InstrProfSymtab implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef std::vector<std::pair<uint64_t, uint64_t> > AddrHashMap
//  public final class AddrHashMap extends std.vector<std.pairULongULong>{ };
/*private:*/
  private StringRef Data;
  private long/*uint64_t*/ Address;
  // Unique name strings.
  private StringSet/*<MallocAllocator>*/ NameTab;
  // A map from MD5 keys to function name strings.
  private std.vector<std.pairULongType<StringRef>> MD5NameMap;
  // A map from MD5 keys to function define. We only populate this map
  // when build the Symtab from a Module.
  private std.vector<std.pairULongType<Function /*P*/ >> MD5FuncMap;
  // A map from function runtime address to function name MD5 hash.
  // This map is only populated and used by raw instr profile reader.
  private std.vector<std.pairULongULong> AddrToMD5Map;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::InstrProfSymtab">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 426,
   FQN="llvm::InstrProfSymtab::InstrProfSymtab", NM="_ZN4llvm15InstrProfSymtabC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtabC1Ev")
  //</editor-fold>
  public InstrProfSymtab() {
    // : Data(), Address(0), NameTab(), MD5NameMap(), MD5FuncMap(), AddrToMD5Map() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Create InstrProfSymtab from an object file section which
  /// contains function PGO names. When section may contain raw
  /// string data or string data in compressed form. This method
  /// only initialize the symtab with reference to the data and
  /// the section base address. The decompression will be delayed
  /// until before it is used. See also \c create(StringRef) method.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp", line = 327,
   FQN="llvm::InstrProfSymtab::create", NM="_ZN4llvm15InstrProfSymtab6createERNS_6object10SectionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtab6createERNS_6object10SectionRefE")
  //</editor-fold>
  public Error create(final SectionRef /*&*/ Section) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// This interface is used by reader of CoverageMapping test
  /// format.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 488,
   FQN="llvm::InstrProfSymtab::create", NM="_ZN4llvm15InstrProfSymtab6createENS_9StringRefEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtab6createENS_9StringRefEy")
  //</editor-fold>
  public Error create(StringRef D, long/*uint64_t*/ BaseAddr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// \c NameStrings is a string composed of one of more sub-strings
  ///  encoded in the format described in \c collectPGOFuncNameStrings.
  /// This method is a wrapper to \c readPGOFuncNameStrings method.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 494,
   FQN="llvm::InstrProfSymtab::create", NM="_ZN4llvm15InstrProfSymtab6createENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtab6createENS_9StringRefE")
  //</editor-fold>
  public Error create(StringRef NameStrings) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// A wrapper interface to populate the PGO symtab with functions
  /// decls from module \c M. This interface is used by transformation
  /// passes such as indirect function call promotion. Variable \c InLTO
  /// indicates if this is called from LTO optimization passes.
  /// A wrapper interface to populate the PGO symtab with functions
  /// decls from module \c M. This interface is used by transformation
  /// passes such as indirect function call promotion. Variable \c InLTO
  /// indicates if this is called from LTO optimization passes.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 224,
   FQN="llvm::InstrProfSymtab::create", NM="_ZN4llvm15InstrProfSymtab6createERNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfSymtab6createERNS_6ModuleEb")
  //</editor-fold>
  public void create(final Module /*&*/ M) {
    create(M, false);
  }
  public void create(final Module /*&*/ M, boolean InLTO/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  /// Create InstrProfSymtab from a set of names iteratable from
  /// \p IterRange. This interface is used by IndexedProfReader.
  /*template <typename NameIterRange> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 499,
   FQN="llvm::InstrProfSymtab::create", NM="Tpl__ZN4llvm15InstrProfSymtab6createERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=Tpl__ZN4llvm15InstrProfSymtab6createERKT_")
  //</editor-fold>
  public </*typename*/ NameIterRange> void create$T(final /*const*/ NameIterRange /*&*/ IterRange) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // If the symtab is created by a series of calls to \c addFuncName, \c
  // finalizeSymtab needs to be called before looking up function names.
  // This is required because the underlying map is a vector (for space
  // efficiency) which needs to be sorted.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::finalizeSymtab">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 506,
   FQN="llvm::InstrProfSymtab::finalizeSymtab", NM="_ZN4llvm15InstrProfSymtab14finalizeSymtabEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtab14finalizeSymtabEv")
  //</editor-fold>
  public void finalizeSymtab() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Update the symtab by adding \p FuncName to the table. This interface
  /// is used by the raw and text profile readers.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::addFuncName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 459,
   FQN="llvm::InstrProfSymtab::addFuncName", NM="_ZN4llvm15InstrProfSymtab11addFuncNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtab11addFuncNameENS_9StringRefE")
  //</editor-fold>
  public void addFuncName(StringRef FuncName) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Map a function address to its name's MD5 hash. This interface
  /// is only used by the raw profiler reader.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::mapAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 467,
   FQN="llvm::InstrProfSymtab::mapAddress", NM="_ZN4llvm15InstrProfSymtab10mapAddressEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtab10mapAddressEyy")
  //</editor-fold>
  public void mapAddress(long/*uint64_t*/ Addr, long/*uint64_t*/ MD5Val) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::getAddrHashMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 470,
   FQN="llvm::InstrProfSymtab::getAddrHashMap", NM="_ZN4llvm15InstrProfSymtab14getAddrHashMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtab14getAddrHashMapEv")
  //</editor-fold>
  public std.vector<std.pairULongULong> /*&*/ getAddrHashMap() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Return function's PGO name from the function name's symbol
  /// address in the object file. If an error occurs, return
  /// an empty string.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::getFuncName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp", line = 334,
   FQN="llvm::InstrProfSymtab::getFuncName", NM="_ZN4llvm15InstrProfSymtab11getFuncNameEyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtab11getFuncNameEyj")
  //</editor-fold>
  public StringRef getFuncName(long/*uint64_t*/ Pointer, /*size_t*/int Size) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Return function's PGO name from the name's md5 hash value.
  /// If not found, return an empty string.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::getFuncName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 514,
   FQN="llvm::InstrProfSymtab::getFuncName", NM="_ZN4llvm15InstrProfSymtab11getFuncNameEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtab11getFuncNameEy")
  //</editor-fold>
  public StringRef getFuncName(long/*uint64_t*/ FuncMD5Hash) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Return function from the name's md5 hash. Return nullptr if not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::getFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 524,
   FQN="llvm::InstrProfSymtab::getFunction", NM="_ZN4llvm15InstrProfSymtab11getFunctionEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtab11getFunctionEy")
  //</editor-fold>
  public Function /*P*/ getFunction(long/*uint64_t*/ FuncMD5Hash) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Return the function's original assembly name by stripping off
  /// the prefix attached (to symbols with priviate linkage). For
  /// global functions, it returns the same string as getFuncName.
  
  // See also getPGOFuncName implementation. These two need to be
  // matched.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::getOrigFuncName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 536,
   FQN="llvm::InstrProfSymtab::getOrigFuncName", NM="_ZN4llvm15InstrProfSymtab15getOrigFuncNameEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtab15getOrigFuncNameEy")
  //</editor-fold>
  public StringRef getOrigFuncName(long/*uint64_t*/ FuncMD5Hash) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Return the name section data.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::getNameData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 485,
   FQN="llvm::InstrProfSymtab::getNameData", NM="_ZNK4llvm15InstrProfSymtab11getNameDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm15InstrProfSymtab11getNameDataEv")
  //</editor-fold>
  public /*inline*/ StringRef getNameData() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfSymtab::~InstrProfSymtab">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 407,
   FQN="llvm::InstrProfSymtab::~InstrProfSymtab", NM="_ZN4llvm15InstrProfSymtabD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm15InstrProfSymtabD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Data=" + Data // NOI18N
              + ", Address=" + Address // NOI18N
              + ", NameTab=" + NameTab // NOI18N
              + ", MD5NameMap=" + MD5NameMap // NOI18N
              + ", MD5FuncMap=" + MD5FuncMap // NOI18N
              + ", AddrToMD5Map=" + AddrToMD5Map; // NOI18N
  }
}
