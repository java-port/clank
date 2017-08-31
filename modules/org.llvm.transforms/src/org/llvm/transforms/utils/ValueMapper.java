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

package org.llvm.transforms.utils;

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
import org.llvm.ir.*;


/// Context for (re-)mapping values (and metadata).
///
/// A shared context used for mapping and remapping of Value and Metadata
/// instances using \a ValueToValueMapTy, \a RemapFlags, \a
/// ValueMapTypeRemapper, and \a ValueMaterializer.
///
/// There are a number of top-level entry points:
/// - \a mapValue() (and \a mapConstant());
/// - \a mapMetadata() (and \a mapMDNode());
/// - \a remapInstruction(); and
/// - \a remapFunction().
///
/// The \a ValueMaterializer can be used as a callback, but cannot invoke any
/// of these top-level functions recursively.  Instead, callbacks should use
/// one of the following to schedule work lazily in the \a ValueMapper
/// instance:
/// - \a scheduleMapGlobalInitializer()
/// - \a scheduleMapAppendingVariable()
/// - \a scheduleMapGlobalAliasee()
/// - \a scheduleRemapFunction()
///
/// Sometimes a callback needs a diferent mapping context.  Such a context can
/// be registered using \a registerAlternateMappingContext(), which takes an
/// alternate \a ValueToValueMapTy and \a ValueMaterializer and returns a ID to
/// pass into the schedule*() functions.
///
/// TODO: lib/Linker really doesn't need the \a ValueHandle in the \a
/// ValueToValueMapTy.  We should template \a ValueMapper (and its
/// implementation classes), and explicitly instantiate on two concrete
/// instances of \a ValueMap (one as \a ValueToValueMap, and one with raw \a
/// Value pointers).  It may be viable to do away with \a TrackingMDRef in the
/// \a Metadata side map for the lib/Linker case as well, in which case we'll
/// need a new template parameter on \a ValueMap.
///
/// TODO: Update callers of \a RemapInstruction() and \a MapValue() (etc.) to
/// use \a ValueMapper directly.
//<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 133,
 FQN="llvm::ValueMapper", NM="_ZN4llvm11ValueMapperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapperE")
//</editor-fold>
public class ValueMapper implements Destructors.ClassWithDestructor {
  private Object/*void P*/ pImpl;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::ValueMapper">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 136,
   FQN="llvm::ValueMapper::ValueMapper", NM="_ZN4llvm11ValueMapperC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapperC1EOS0_")
  //</editor-fold>
  private ValueMapper(JD$Move _dparam, final ValueMapper /*&&*/$Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::ValueMapper">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 137,
   FQN="llvm::ValueMapper::ValueMapper", NM="_ZN4llvm11ValueMapperC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapperC1ERKS0_")
  //</editor-fold>
  private ValueMapper(final /*const*/ ValueMapper /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 138,
   FQN="llvm::ValueMapper::operator=", NM="_ZN4llvm11ValueMapperaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapperaSEOS0_")
  //</editor-fold>
  private ValueMapper /*&*/ $assignMove(final ValueMapper /*&&*/$Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 139,
   FQN="llvm::ValueMapper::operator=", NM="_ZN4llvm11ValueMapperaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapperaSERKS0_")
  //</editor-fold>
  private ValueMapper /*&*/ $assign(final /*const*/ ValueMapper /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::ValueMapper">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 142,
   FQN="llvm::ValueMapper::ValueMapper", NM="_ZN4llvm11ValueMapperC1ERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS4_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapperC1ERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS4_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE")
  //</editor-fold>
  public ValueMapper(final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM) {
    this(VM, RemapFlags.RF_None, 
      (ValueMapTypeRemapper /*P*/ )null, 
      (ValueMaterializer /*P*/ )null);
  }
  public ValueMapper(final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, RemapFlags Flags/*= RF_None*/) {
    this(VM, Flags, 
      (ValueMapTypeRemapper /*P*/ )null, 
      (ValueMaterializer /*P*/ )null);
  }
  public ValueMapper(final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, RemapFlags Flags/*= RF_None*/, 
      ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/) {
    this(VM, Flags, 
      TypeMapper, 
      (ValueMaterializer /*P*/ )null);
  }
  public ValueMapper(final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, RemapFlags Flags/*= RF_None*/, 
      ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/, 
      ValueMaterializer /*P*/ Materializer/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::~ValueMapper">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 145,
   FQN="llvm::ValueMapper::~ValueMapper", NM="_ZN4llvm11ValueMapperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapperD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Register an alternate mapping context.
  ///
  /// Returns a MappingContextID that can be used with the various schedule*()
  /// API to switch in a different value map on-the-fly.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::registerAlternateMappingContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 151,
   FQN="llvm::ValueMapper::registerAlternateMappingContext", NM="_ZN4llvm11ValueMapper31registerAlternateMappingContextERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS4_NS_3sys10SmartMutexILb0EEEEEEEPNS_17ValueMaterializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper31registerAlternateMappingContextERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS4_NS_3sys10SmartMutexILb0EEEEEEEPNS_17ValueMaterializerE")
  //</editor-fold>
  public /*uint*/int registerAlternateMappingContext(final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM) {
    return registerAlternateMappingContext(VM, 
                                 (ValueMaterializer /*P*/ )null);
  }
  public /*uint*/int registerAlternateMappingContext(final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
                                 ValueMaterializer /*P*/ Materializer/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Add to the current \a RemapFlags.
  ///
  /// \note Like the top-level mapping functions, \a addFlags() must be called
  /// at the top level, not during a callback in a \a ValueMaterializer.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::addFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 159,
   FQN="llvm::ValueMapper::addFlags", NM="_ZN4llvm11ValueMapper8addFlagsENS_10RemapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper8addFlagsENS_10RemapFlagsE")
  //</editor-fold>
  public void addFlags(RemapFlags Flags) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::mapMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 161,
   FQN="llvm::ValueMapper::mapMetadata", NM="_ZN4llvm11ValueMapper11mapMetadataERKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper11mapMetadataERKNS_8MetadataE")
  //</editor-fold>
  public Metadata /*P*/ mapMetadata(final /*const*/ Metadata /*&*/ MD) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::mapMDNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 162,
   FQN="llvm::ValueMapper::mapMDNode", NM="_ZN4llvm11ValueMapper9mapMDNodeERKNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper9mapMDNodeERKNS_6MDNodeE")
  //</editor-fold>
  public MDNode /*P*/ mapMDNode(final /*const*/ MDNode /*&*/ N) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::mapValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 164,
   FQN="llvm::ValueMapper::mapValue", NM="_ZN4llvm11ValueMapper8mapValueERKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper8mapValueERKNS_5ValueE")
  //</editor-fold>
  public Value /*P*/ mapValue(final /*const*/ Value /*&*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::mapConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 165,
   FQN="llvm::ValueMapper::mapConstant", NM="_ZN4llvm11ValueMapper11mapConstantERKNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper11mapConstantERKNS_8ConstantE")
  //</editor-fold>
  public Constant /*P*/ mapConstant(final /*const*/ Constant /*&*/ C) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::remapInstruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 167,
   FQN="llvm::ValueMapper::remapInstruction", NM="_ZN4llvm11ValueMapper16remapInstructionERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper16remapInstructionERNS_11InstructionE")
  //</editor-fold>
  public void remapInstruction(final Instruction /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::remapFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 168,
   FQN="llvm::ValueMapper::remapFunction", NM="_ZN4llvm11ValueMapper13remapFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper13remapFunctionERNS_8FunctionE")
  //</editor-fold>
  public void remapFunction(final Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::scheduleMapGlobalInitializer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 170,
   FQN="llvm::ValueMapper::scheduleMapGlobalInitializer", NM="_ZN4llvm11ValueMapper28scheduleMapGlobalInitializerERNS_14GlobalVariableERNS_8ConstantEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper28scheduleMapGlobalInitializerERNS_14GlobalVariableERNS_8ConstantEj")
  //</editor-fold>
  public void scheduleMapGlobalInitializer(final GlobalVariable /*&*/ GV, final Constant /*&*/ Init) {
    scheduleMapGlobalInitializer(GV, Init, 
                              0);
  }
  public void scheduleMapGlobalInitializer(final GlobalVariable /*&*/ GV, final Constant /*&*/ Init, 
                              /*uint*/int MappingContextID/*= 0*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::scheduleMapAppendingVariable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 172,
   FQN="llvm::ValueMapper::scheduleMapAppendingVariable", NM="_ZN4llvm11ValueMapper28scheduleMapAppendingVariableERNS_14GlobalVariableEPNS_8ConstantEbNS_8ArrayRefIS4_EEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper28scheduleMapAppendingVariableERNS_14GlobalVariableEPNS_8ConstantEbNS_8ArrayRefIS4_EEj")
  //</editor-fold>
  public void scheduleMapAppendingVariable(final GlobalVariable /*&*/ GV, Constant /*P*/ InitPrefix, 
                              boolean IsOldCtorDtor, 
                              ArrayRef<Constant /*P*/ > NewMembers) {
    scheduleMapAppendingVariable(GV, InitPrefix, 
                              IsOldCtorDtor, 
                              NewMembers, 
                              0);
  }
  public void scheduleMapAppendingVariable(final GlobalVariable /*&*/ GV, Constant /*P*/ InitPrefix, 
                              boolean IsOldCtorDtor, 
                              ArrayRef<Constant /*P*/ > NewMembers, 
                              /*uint*/int MappingContextID/*= 0*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::scheduleMapGlobalAliasee">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 176,
   FQN="llvm::ValueMapper::scheduleMapGlobalAliasee", NM="_ZN4llvm11ValueMapper24scheduleMapGlobalAliaseeERNS_11GlobalAliasERNS_8ConstantEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper24scheduleMapGlobalAliaseeERNS_11GlobalAliasERNS_8ConstantEj")
  //</editor-fold>
  public void scheduleMapGlobalAliasee(final GlobalAlias /*&*/ GA, final Constant /*&*/ Aliasee) {
    scheduleMapGlobalAliasee(GA, Aliasee, 
                          0);
  }
  public void scheduleMapGlobalAliasee(final GlobalAlias /*&*/ GA, final Constant /*&*/ Aliasee, 
                          /*uint*/int MappingContextID/*= 0*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapper::scheduleRemapFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 178,
   FQN="llvm::ValueMapper::scheduleRemapFunction", NM="_ZN4llvm11ValueMapper21scheduleRemapFunctionERNS_8FunctionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm11ValueMapper21scheduleRemapFunctionERNS_8FunctionEj")
  //</editor-fold>
  public void scheduleRemapFunction(final Function /*&*/ F) {
    scheduleRemapFunction(F, 0);
  }
  public void scheduleRemapFunction(final Function /*&*/ F, /*uint*/int MappingContextID/*= 0*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "pImpl=" + pImpl; // NOI18N
  }
}
